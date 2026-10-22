package com.larus.uaigc.bean.chat.template;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import w1a.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/bean/chat/template/TemplateChooseState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "foo", "", "<init>", "(Z)V", "getFoo", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateChooseState implements b {
    private final boolean foo;

    public TemplateChooseState() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ TemplateChooseState copy$default(TemplateChooseState r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.foo;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.foo;
    }

    public final TemplateChooseState copy(boolean r100) {
        return new TemplateChooseState(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TemplateChooseState) == true) goto L9;
        return false;
    L9:
        if (this.foo == ((TemplateChooseState) r100).foo) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.foo == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "TemplateChooseState(foo=" + this.foo + ')';
    }

    public final boolean getFoo() {
        return this.foo;
    }

    public TemplateChooseState(boolean r100) {
        this.foo = r100;
    }

    public /* synthetic */ TemplateChooseState(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }
}
