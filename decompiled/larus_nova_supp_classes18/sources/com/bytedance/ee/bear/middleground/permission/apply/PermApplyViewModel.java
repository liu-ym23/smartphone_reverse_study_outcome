package com.bytedance.ee.bear.middleground.permission.apply;

import android.app.Application;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.AccountService;
import com.google.gson.Gson;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0003012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\rJ\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001a\u0004\u0018\u00010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010!R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel;", "Landroidx/lifecycle/ViewModel;", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;)V", "getParams", "()Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "appContext", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "_permType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel$PermType;", "get_permType", "()Landroidx/lifecycle/MutableLiveData;", "_permType$delegate", "Lkotlin/Lazy;", "permType", "Landroidx/lifecycle/LiveData;", "getPermType", "()Landroidx/lifecycle/LiveData;", "tipsText", "", "getTipsText", "()Ljava/lang/String;", "ownerText", "Landroid/text/Spanned;", "getOwnerText", "()Landroid/text/Spanned;", "ownerStr", "getOwnerStr", "setOwnerStr", "(Ljava/lang/String;)V", "getDisplayName", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "applyDocPermPuller", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller;", "getApplyDocPermPuller", "()Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller;", "applyDocPermPuller$delegate", "setPermType", "", "requestPerm", "Lio/reactivex/Flowable;", "", "msg", "Companion", "Factory", "PermType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermApplyViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "PermApplyViewModel";
    private final Lazy _permType$delegate;
    private final Application appContext;
    private final Lazy applyDocPermPuller$delegate;
    public String ownerStr;
    private final Spanned ownerText;
    private final NoPermission params;
    private final String tipsText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel$PermType;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "READ", "EDIT", "getText", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PermType extends Enum<PermType> {
        public static final PermType EDIT = null;
        public static final PermType READ = null;
        public static final /* synthetic */ PermType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int code;

        public static EnumEntries<PermType> getEntries() {
            return b;
        }

        static {
            PermType r0 = new PermType("READ", 0, 1);
            READ = r0;
            PermType r1 = new PermType("EDIT", 1, 4);
            EDIT = r1;
            PermType[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static PermType[] values() {
            return (PermType[]) a.clone();
        }

        public final String getText() {
            int r0 = this.code;
            if (r0 == 1) goto L9;
            if (r0 == 4) goto L11;
            return "";
        L11:
            return eu5.b.a.getString(2131887750);
        L9:
            return eu5.b.a.getString(2131887806);
        }

        public final int getCode() {
            return this.code;
        }

        public static PermType valueOf(String r1) {
            return (PermType) r27.a.a(PermType.class, r1);
        }

        public PermType(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static PermApplyViewModel a(Fragment r1, NoPermission r2) {
            Intrinsics.checkNotNullParameter(r1, "fragment");
            Intrinsics.checkNotNullParameter(r2, "params");
            return (PermApplyViewModel) ViewModelProviders.of(r1, new b(r2)).get(PermApplyViewModel.class);
        }
    }

    public static final class b implements ViewModelProvider.Factory {
        public final NoPermission a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public b(NoPermission r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "modelClass");
            return r5.getConstructor(new Class[]{NoPermission.class}).newInstance(new Object[]{this.a});
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((ApplyDocPermPuller.Result) r2, "it");
            return Boolean.TRUE;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final PermApplyViewModel get(Fragment r1, NoPermission r2) {
        Companion.getClass();
        return a.a(r1, r2);
    }

    private final ApplyDocPermPuller getApplyDocPermPuller() {
        return (ApplyDocPermPuller) this.applyDocPermPuller$delegate.getValue();
    }

    private final MutableLiveData<PermType> get_permType() {
        return (MutableLiveData) this._permType$delegate.getValue();
    }

    public final String getOwnerStr() {
        String r0 = this.ownerStr;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("ownerStr");
        return null;
    }

    public final LiveData<PermType> getPermType() {
        return get_permType();
    }

    public final Spanned getOwnerText() {
        return this.ownerText;
    }

    public final NoPermission getParams() {
        return this.params;
    }

    public final String getTipsText() {
        return this.tipsText;
    }

    public PermApplyViewModel(NoPermission r18) {
        Intrinsics.checkNotNullParameter(r18, "params");
        this.params = r18;
        Application r2 = eu5.b.a;
        this.appContext = r2;
        this._permType$delegate = LazyKt.lazy(PermApplyViewModel$_permType$2.INSTANCE);
        this.tipsText = r2.getString(2131888103);
        AccountService.Account r3 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r3 == null) goto L34;
        LinkedHashMap r7 = new LinkedHashMap();
        String r4 = ou5.a.d(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a(), getDisplayName(r3), r3.userName, r3.enName);
        if (r3.isConsumer() == false) goto L7;
        String r5 = r2.getString(2131888107);
    L8:
        String r6 = r18.getOwnerName();
        Pattern r0 = yu5.c.a;
    L30:
        th = move-exception;
        tt5.a.d("StringUtils", "tryGetStringWithoutTwoSpace fails：" + th);
    L32:
        this.appContext.getString(2131888102);
        r7.put("user", b0.a(r5 + '-' + r4));
        r7.put("owner", String.format("<font color=%s>%s</font>", new Object[]{String.valueOf(eu5.b.a.getResources().getColor(2131105548)), b0.a(r6)}));
        setOwnerStr(r6);
        Unit r1 = Unit.INSTANCE;
        Spanned r8 = Html.fromHtml(xo5.a.d(r2, 2131888084, r7));
        if (r8 == null) goto L34;
    L35:
        this.ownerText = r8;
        this.applyDocPermPuller$delegate = LazyKt.lazy(PermApplyViewModel$applyDocPermPuller$2.INSTANCE);
        return;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L32;
        r6 = r6.trim();     // Catch: Throwable -> L30
        String[] r10 = r6.split(" ");     // Catch: Throwable -> L30
        StringBuffer r11 = new StringBuffer();     // Catch: Throwable -> L30
        if (r10 == null) goto L15;
    L17:
        int r12 = r10.length;     // Catch: Throwable -> L30
        int r13 = 0;
        boolean r14 = false;
    L18:
        if (r13 >= r12) goto L28;
        String r15 = r10[r13];     // Catch: Throwable -> L30
        if ("".equals(r15) == false) goto L24;
        if (r14 == true) goto L27;
        r11.append(" ");     // Catch: Throwable -> L30
        r14 = true;
    L27:
        r13 = r13 + 1;     // Catch: Throwable -> L30
        goto L18
    L24:
        if (r14 == true) goto L26;
        r11.append(" ");     // Catch: Throwable -> L30
    L26:
        r11.append(r15);     // Catch: Throwable -> L30
        r14 = false;
        goto L27
    L28:
        r6 = r11.toString().trim();     // Catch: Throwable -> L30
        goto L32
    L15:
        if (r10.length > 0) goto L17;
    L7:
        r5 = r3.tenantName;
    L34:
        r8 = new SpannableString("");
        goto L35
    }

    public final String getDisplayName(AccountService.Account r3) {
        Intrinsics.checkNotNullParameter(r3, "account");
        DisplayName r0 = new DisplayName();
        r0.setValue(r3.displayName);
        String r4 = new Gson().toJson(r0);     // Catch: Throwable -> L5
    L6:
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        r4 = r3.displayName;
        tt5.a.d(TAG, "displayname Error");
        goto L6
    }

    public final Flowable<Boolean> requestPerm(String r7) {
        ApplyDocPermPuller r0 = getApplyDocPermPuller();
        String r2 = this.params.getToken();
        String r3 = this.params.getDocumentType();
        String r4 = "";
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        PermType r5 = (PermType) get_permType().getValue();
        if (r5 == null) goto L12;
        String r6 = Integer.valueOf(r5.getCode()).toString();
        if (r6 == null) goto L12;
        r4 = r6;
    L12:
        return r0.a(new ApplyDocPermPuller.Params(r2, r3, r7, r4)).map(c.a);
    }

    public final void setOwnerStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerStr = r2;
    }

    public final void setPermType(PermType r2) {
        Intrinsics.checkNotNullParameter(r2, "permType");
        get_permType().setValue(r2);
    }
}
