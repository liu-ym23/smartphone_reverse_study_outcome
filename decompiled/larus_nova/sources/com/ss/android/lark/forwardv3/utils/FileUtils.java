package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.framework.callback.UICallbackExecutor;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f425553a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/forwardv3/utils/FileUtils$ReceiveAuthorizationState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MIDDLE_AUTHORIZATION_STATE", "FINAL_AUTHORIZATION_STATE_PASS", "FINAL_AUTHORIZATION_STATE_DENY", "NORMAL_STATE", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
        public static final a Companion = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
        public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
        public static final ReceiveAuthorizationState NORMAL_STATE = null;
        public static final ReceiveAuthorizationState UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReceiveAuthorizationState[] f425554a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f425555b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ReceiveAuthorizationState> getEntries() {
            return f425555b;
        }

        static {
            ReceiveAuthorizationState r100 = new ReceiveAuthorizationState("UNKNOWN", 0);
            UNKNOWN = r100;
            ReceiveAuthorizationState r101 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1);
            MIDDLE_AUTHORIZATION_STATE = r101;
            ReceiveAuthorizationState r102 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2);
            FINAL_AUTHORIZATION_STATE_PASS = r102;
            ReceiveAuthorizationState r103 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3);
            FINAL_AUTHORIZATION_STATE_DENY = r103;
            ReceiveAuthorizationState r104 = new ReceiveAuthorizationState("NORMAL_STATE", 4);
            NORMAL_STATE = r104;
            ReceiveAuthorizationState[] r105 = {r100, r101, r102, r103, r104};
            f425554a = r105;
            f425555b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static ReceiveAuthorizationState[] values() {
            return (ReceiveAuthorizationState[]) f425554a.clone();
        }

        public static ReceiveAuthorizationState valueOf(String r100) {
            return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r100);
        }

        public ReceiveAuthorizationState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f425556a = null;

        static {
            int[] r100 = new int[ReceiveAuthorizationState.values().length];
            r100[ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f425556a = r100;
        }
    }

    static {
    }

    public static void a(Context r100, FilePermCheckBlockInfo r101) {
        if (r100 == null) goto L17;
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101.popup_title) == true) goto L14;
        if (TextUtils.isEmpty(r101.popup_text) == true) goto L14;
        if (TextUtils.isEmpty(r101.button) == true) goto L14;
        UICallbackExecutor.execute(new c(r100, r101));
        return;
    L14:
        if (TextUtils.isEmpty(r101.toast) == true) goto L18;
        UICallbackExecutor.execute(new d(r100, r101));
        return;
    L18:
        return;
    }
}
