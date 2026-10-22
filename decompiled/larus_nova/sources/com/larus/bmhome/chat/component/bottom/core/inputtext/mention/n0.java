package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298947a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f298948b = null;

        static {
            int[] r100 = new int[InputReferenceType.values().length];
            r100[InputReferenceType.CONTACT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[InputReferenceType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r100[InputReferenceType.ATTACHMENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[InputReferenceType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[InputReferenceType.SKILL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r100[InputReferenceType.DRIVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r100[InputReferenceType.CONVERSATION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            f298947a = r100;
            int[] r101 = new int[MentionSearchDomain.values().length];
            r101[MentionSearchDomain.CONTACT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r101[MentionSearchDomain.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r101[MentionSearchDomain.DRIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r101[MentionSearchDomain.CONVERSATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            f298948b = r101;
        }
    }

    public static final String a(MentionSearchDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f298948b[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "contact";
    L5:
        if (r101 != 2) goto L7;
        return "group_chat";
    L7:
        if (r101 != 3) goto L9;
        return "cloud_doc";
    L9:
        if (r101 != 4) goto L12;
        return "conversation";
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
