package com.ss.android.lark.widget.span;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/widget/span/HRInfo;", "Lcom/ss/android/lark/widget/span/SpanInfo;", "<init>", "()V", "addEnterBeforeSpan", "", "getAddEnterBeforeSpan", "()Z", "setAddEnterBeforeSpan", "(Z)V", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HRInfo extends SpanInfo {
    public static final a Companion = null;
    public static final String HR_PLACEHOLDER = " ";
    private boolean addEnterBeforeSpan;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public HRInfo() {
        this.text = " ";
    }

    public final boolean getAddEnterBeforeSpan() {
        return this.addEnterBeforeSpan;
    }

    public final void setAddEnterBeforeSpan(boolean r100) {
        this.addEnterBeforeSpan = r100;
    }
}
