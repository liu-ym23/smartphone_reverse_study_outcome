package com.bytedance.ee.bear.tts.tone;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/tts/tone/TtsToneListBean;", "Ljava/io/Serializable;", "<init>", "()V", "defaultTone", "Lcom/bytedance/ee/bear/tts/tone/TtsToneBean;", "getDefaultTone", "()Lcom/bytedance/ee/bear/tts/tone/TtsToneBean;", "setDefaultTone", "(Lcom/bytedance/ee/bear/tts/tone/TtsToneBean;)V", "toneList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getToneList", "()Ljava/util/ArrayList;", "setToneList", "(Ljava/util/ArrayList;)V", "toString", "", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsToneListBean implements Serializable {
    private TtsToneBean defaultTone;
    private ArrayList<TtsToneBean> toneList;

    public TtsToneListBean() {
    }

    public String toString() {
        return "TtsToneListBean@" + hashCode() + "{defaultTone: " + this.defaultTone + ", toneList: " + this.toneList + '}';
    }

    public final TtsToneBean getDefaultTone() {
        return this.defaultTone;
    }

    public final ArrayList<TtsToneBean> getToneList() {
        return this.toneList;
    }

    public final void setDefaultTone(TtsToneBean r1) {
        this.defaultTone = r1;
    }

    public final void setToneList(ArrayList<TtsToneBean> r1) {
        this.toneList = r1;
    }
}
