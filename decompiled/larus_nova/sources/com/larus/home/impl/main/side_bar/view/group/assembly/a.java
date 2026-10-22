package com.larus.home.impl.main.side_bar.view.group.assembly;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.group.assembly.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4323a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345161a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f345162b = null;

        static {
            int[] r100 = new int[ConversationGroupPolicy.values().length];
            r100[ConversationGroupPolicy.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[ConversationGroupPolicy.Project.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[ConversationGroupPolicy.Device.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[ConversationGroupPolicy.Time.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f345161a = r100;
            int[] r101 = new int[GroupSortPolicy.values().length];
            r101[GroupSortPolicy.UpdateTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[GroupSortPolicy.CreateTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[GroupSortPolicy.PinTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f345162b = r101;
        }
    }

    public static final String a(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = C4323a.f345162b[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "update_time";
    L5:
        if (r101 != 2) goto L7;
        return "create_time";
    L7:
        if (r101 != 3) goto L10;
        return "pin_time";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final String b(ConversationGroupPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = C4323a.f345161a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "none";
    L5:
        if (r101 != 2) goto L7;
        return SlashMentionConfig.SLASH_CONTENT_PROJECT;
    L7:
        if (r101 != 3) goto L9;
        return "device";
    L9:
        if (r101 != 4) goto L12;
        return "time";
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
