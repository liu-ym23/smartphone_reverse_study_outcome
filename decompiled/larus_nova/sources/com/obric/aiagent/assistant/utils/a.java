package com.obric.aiagent.assistant.utils;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384611a = 0;

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes6.dex */
    public /* synthetic */ class C4583a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f384612a = null;

        static {
            int[] r100 = new int[PrivacyApprovalStatus.values().length];
            r100[PrivacyApprovalStatus.NotApproved.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PrivacyApprovalStatus.CannotObtain.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PrivacyApprovalStatus.Timeout.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PrivacyApprovalStatus.Approved.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f384612a = r100;
        }
    }

    static {
    }

    public static DefaultAssistantStatus a(Context r100) {
        if (r100 == null) goto L4;
        b.f384613a.getClass();
        String r101 = b.d(r100);
        if (r101 != null) goto L10;
        return DefaultAssistantStatus.Unknown;
    L10:
        if (Intrinsics.areEqual(r101, "com.larus.nova") == false) goto L14;
        return DefaultAssistantStatus.IsDefaultAssistant;
    L14:
        return DefaultAssistantStatus.NotDefaultAssistant;
    L4:
        return DefaultAssistantStatus.Unknown;
    }
}
