package com.ss.android.lark.inline.ai.api.ui;

import com.alipay.sdk.m.x.d;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/PromptGroup;", "Ljava/io/Serializable;", "title", "", "prompts", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/ui/Prompt;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getPrompts", "()Ljava/util/ArrayList;", "setPrompts", "(Ljava/util/ArrayList;)V", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptGroup implements Serializable {
    private ArrayList<Prompt> prompts;
    private String title;

    /* JADX WARN: Multi-variable type inference failed */
    public PromptGroup() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromptGroup copy$default(PromptGroup r100, String r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.prompts;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.title;
    }

    public final ArrayList<Prompt> component2() {
        return this.prompts;
    }

    public final PromptGroup copy(String r100, ArrayList<Prompt> r101) {
        return new PromptGroup(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PromptGroup) == true) goto L8;
        return false;
    L8:
        PromptGroup r101 = (PromptGroup) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prompts, r101.prompts) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<Prompt> r104 = this.prompts;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("PromptGroup(title=");
        r100.append(this.title);
        r100.append(", prompts size=");
        ArrayList<Prompt> r101 = this.prompts;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final ArrayList<Prompt> getPrompts() {
        return this.prompts;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setPrompts(ArrayList<Prompt> r100) {
        this.prompts = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public PromptGroup(String r100, ArrayList<Prompt> r101) {
        this.title = r100;
        this.prompts = r101;
    }

    public /* synthetic */ PromptGroup(String r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
