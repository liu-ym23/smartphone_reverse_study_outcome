package com.larus.feishu.office.im.impl.officemention;

import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f343257a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f343258a = null;

        static {
            int[] r100 = new int[RichTextElement.RichTextTag.values().length];
            r100[RichTextElement.RichTextTag.AT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f343258a = r100;
        }
    }

    static {
    }
}
