package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MessagePermissionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4b.u f416615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f416616b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.ss.android.lark.auditsdk.v2.d f416617c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/utils/MessagePermissionUtil$ReceiveAuthorizationState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MIDDLE_AUTHORIZATION_STATE", "FINAL_AUTHORIZATION_STATE_PASS", "FINAL_AUTHORIZATION_STATE_DENY", "NORMAL_STATE", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
        public static final a Companion = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
        public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
        public static final ReceiveAuthorizationState NORMAL_STATE = null;
        public static final ReceiveAuthorizationState UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReceiveAuthorizationState[] f416618a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416619b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static ReceiveAuthorizationState a(int r100) {
                if (r100 == 0) goto L17;
                if (r100 == 1) goto L22;
                if (r100 == 2) goto L21;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L19;
                return ReceiveAuthorizationState.UNKNOWN;
            L19:
                return ReceiveAuthorizationState.NORMAL_STATE;
            L20:
                return ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY;
            L21:
                return ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS;
            L22:
                return ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE;
            L17:
                return ReceiveAuthorizationState.UNKNOWN;
            }
        }

        @JvmStatic
        public static final ReceiveAuthorizationState fromValue(int r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static EnumEntries<ReceiveAuthorizationState> getEntries() {
            return f416619b;
        }

        static {
            ReceiveAuthorizationState r100 = new ReceiveAuthorizationState("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ReceiveAuthorizationState r101 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1, 1);
            MIDDLE_AUTHORIZATION_STATE = r101;
            ReceiveAuthorizationState r102 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2, 2);
            FINAL_AUTHORIZATION_STATE_PASS = r102;
            ReceiveAuthorizationState r103 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3, 3);
            FINAL_AUTHORIZATION_STATE_DENY = r103;
            ReceiveAuthorizationState r104 = new ReceiveAuthorizationState("NORMAL_STATE", 4, 4);
            NORMAL_STATE = r104;
            ReceiveAuthorizationState[] r105 = {r100, r101, r102, r103, r104};
            f416618a = r105;
            f416619b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static ReceiveAuthorizationState[] values() {
            return (ReceiveAuthorizationState[]) f416618a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ReceiveAuthorizationState valueOf(String r100) {
            return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r100);
        }

        public ReceiveAuthorizationState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416620a = null;

        static {
            int[] r100 = new int[ReceiveAuthorizationState.values().length];
            r100[ReceiveAuthorizationState.NORMAL_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ReceiveAuthorizationState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f416620a = r100;
        }
    }

    static {
        f416615a = ChatCoreModule.a().getLoginDependency();
        f416616b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MessagePermissionUtil$passportDependency$2.INSTANCE);
        f416617c = ChatCoreModule.a().getAuditDependency().g();
    }

    @JvmStatic
    public static final PolicyModel a() {
        EntityDomain r100 = ImFileAuthorityChecker.f409627f;
        FileBizDomain r101 = ImFileAuthorityChecker.f409628g;
        Lazy r102 = f416616b;
        String r103 = ((w4b.c.o) r102.getValue()).userId();
        if (r103 == null) goto L5;
        long r104 = CastLongProtector.parseLong(r103);
    L6:
        long r105 = CastLongProtector.parseLong(((w4b.c.o) r102.getValue()).fe());
        IMFileEntity r210 = new IMFileEntity("IM_MSG_FILE", r100, "IM_MSG_FILE_READ", r105, r104, r101, null, null, null, null, null, null, null, null, null, 32704, null);
        String r110 = "PointKey_IM_MSG_FILE_READ";
        int r111 = 4;
        return new PolicyModel(r110, r210, null, r111, null);
    L5:
        r104 = 0;
        goto L6
    }

    @JvmStatic
    public static final ValidateResult b() {
        return f416617c.c(true);
    }

    @JvmStatic
    public static final boolean e(ValidateResult r100) {
        Intrinsics.checkNotNullParameter(r100, "validateResult");
        return f416617c.isAuthorizationPassed(r100);
    }

    @JvmStatic
    public static final boolean g(ReceiveAuthorizationState r100) {
        Intrinsics.checkNotNullParameter(r100, "receiveAuthorizationState");
        int r101 = a.f416620a[r100.ordinal()];
        if (r101 != 1) goto L5;
    L15:
        return false;
    L5:
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L15;
        if (r101 != 4) goto L11;
        return true;
    L11:
        if (r101 != 5) goto L14;
        return true;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final ReceiveAuthorizationState h(IMFileResult r100) {
        if (r100 == null) goto L6;
        int r101 = r100.getValue();
        ReceiveAuthorizationState.Companion.getClass();
        ReceiveAuthorizationState r102 = ReceiveAuthorizationState.a.a(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return ReceiveAuthorizationState.NORMAL_STATE;
    }

    @JvmStatic
    public static final void m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDToast.show(r100, R.string.Lark_IM_UnableToViewTryAgainLater_Toast);
    }

    @JvmStatic
    public static final boolean j(Message r100, String r101) {
        if (r100 != null) goto L6;
        Log.i("MessagePermissionUtil", "checking sendFromCurrentUser, given Message is null");
        return false;
    L6:
        String r102 = r100.getOriginalSenderId();
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = r100.getFromId();
    L11:
        if (Intrinsics.areEqual(r102, f416615a.getUserId()) == false) goto L13;
    L14:
        return true;
    L13:
        if (Intrinsics.areEqual(r101, r100.getFromId()) == true) goto L14;
        return false;
    }

    @JvmStatic
    public static final boolean k(y6b.a<?> r100, String r101) {
        if (r100 != null) goto L7;
        Log.i("MessagePermissionUtil", "checking sendFromCurrentUser, given MessageVO is null");
        return false;
    L7:
        if ((r100 instanceof y6b.c) == false) goto L13;
        y6b.c r102 = (y6b.c) r100;
        if (TextUtils.isEmpty(r102.f566487g1) == true) goto L11;
        String r103 = r102.f566487g1;
    L17:
        if (Intrinsics.areEqual(r103, f416615a.getUserId()) == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r101, r100.g()) == true) goto L20;
        return false;
    L11:
        r103 = r102.f566486g;
        goto L17
    L13:
        if ((r100 instanceof ThreadMessageVO) == false) goto L15;
        ThreadMessageVO r104 = (ThreadMessageVO) r100;
        r103 = null;
        TextUtils.isEmpty(null);
        goto L17
    L15:
        r103 = "";
        goto L17
    }

    @JvmStatic
    public static final Pair l(ChatImageView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        if (r101 != R.string.Lark_IM_UnableToView_Empty) goto L5;
        String r102 = "";
    L6:
        int r103 = com.ss.android.lark.widget.span.nopreview.a.f448735k;
        com.ss.android.lark.widget.span.nopreview.a.C5434a r104 = com.ss.android.lark.widget.span.nopreview.a.b.a(r100.getContext());
        Intrinsics.checkNotNullParameter(r102, "text");
        r104.f448752g = r102;
        com.ss.android.lark.widget.span.nopreview.a r105 = r104.a();
        r100.setImageDrawable(r105);
        return TuplesKt.to(Integer.valueOf(r105.f448737b), Integer.valueOf(r105.f448738c));
    L5:
        r102 = r100.getContext().getString(r101);
        goto L6
    }

    @JvmStatic
    public static final boolean c(Message r100, Chat r101, ValidateResult r102) {
        boolean r103 = false;
        if (r101 != null) goto L5;
    L7:
        if (r103 == false) goto L9;
        return true;
    L9:
        if (r101 == null) goto L11;
        String r104 = r101.getAnonymousId();
    L13:
        return d(r100, r104, r102);
    L11:
        r104 = null;
        goto L13
    L5:
        if (r101.isSecret() != true) goto L7;
        r103 = true;
        goto L7
    }

    @JvmStatic
    public static final boolean d(Message r100, String r101, ValidateResult r102) {
        if (j(r100, r101) == false) goto L8;
        Lazy r103 = AuditUtilsV2.f409687a;
        if (AuditUtilsV2.b() == true) goto L8;
        return true;
    L8:
        if (r102 != null) goto L11;
        r102 = b();
    L11:
        return e(r102);
    }

    @JvmStatic
    public static final boolean f(y6b.a<?> r100, Chat r101, ValidateResult r102) {
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        return true;
    L10:
        if (r101 == null) goto L12;
        String r104 = r101.getAnonymousId();
    L14:
        if (k(r100, r104) == false) goto L18;
        Lazy r105 = AuditUtilsV2.f409687a;
        if (AuditUtilsV2.b() == true) goto L18;
        return true;
    L18:
        if (r102 != null) goto L21;
        r102 = b();
    L21:
        return e(r102);
    L12:
        r104 = null;
        goto L14
    L5:
        if (r101.isSecret() != true) goto L7;
        r103 = true;
        goto L8
    }

    @JvmStatic
    public static final void n(Context r110, int r111, ValidateResult r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.auditsdk.v2.d r100 = f416617c;
        if (r112 != null) goto L5;
        r112 = b();
    L5:
        com.ss.android.lark.auditsdk.v2.d.a.a(r100, r110, r112, Integer.valueOf(r111), null, Integer.valueOf(R.string.Lark_IM_UnableToPreview_PopUpTitle), r100.e(), null, 408);
    }

    @JvmStatic
    public static final Pair<Integer, Integer> i(Pair<Integer, Integer> r100, int r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r103 = ImageUtils.g(r100.getFirst().intValue(), r100.getSecond().intValue(), r101, r102, r110, r110);
        return TuplesKt.to(Integer.valueOf(r103[0]), Integer.valueOf(r103[1]));
    }
}
