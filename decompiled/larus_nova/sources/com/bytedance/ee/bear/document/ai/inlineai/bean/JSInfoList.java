package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.inline.ai.api.ui.DragBar;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u0013H\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInfoList;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPromptGroup;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "dragBar", "Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "getDragBar", "()Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "setDragBar", "(Lcom/ss/android/lark/inline/ai/api/ui/DragBar;)V", "maskType", "", "getMaskType", "()Ljava/lang/String;", "setMaskType", "(Ljava/lang/String;)V", "update", "", "getUpdate", "()Z", "setUpdate", "(Z)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSInfoList implements NonProguard {
    private ArrayList<JSPromptGroup> data;
    private DragBar dragBar;
    private String maskType;
    private boolean update;

    public JSInfoList() {
    }

    public String toString() {
        return "JSInfoList(data=" + this.data + ", dragBar=" + this.dragBar + ", maskType = " + this.maskType + ", update=" + this.update + ')';
    }

    public final ArrayList<JSPromptGroup> getData() {
        return this.data;
    }

    public final DragBar getDragBar() {
        return this.dragBar;
    }

    public final String getMaskType() {
        return this.maskType;
    }

    public final boolean getUpdate() {
        return this.update;
    }

    public final void setData(ArrayList<JSPromptGroup> r100) {
        this.data = r100;
    }

    public final void setDragBar(DragBar r100) {
        this.dragBar = r100;
    }

    public final void setMaskType(String r100) {
        this.maskType = r100;
    }

    public final void setUpdate(boolean r100) {
        this.update = r100;
    }
}
