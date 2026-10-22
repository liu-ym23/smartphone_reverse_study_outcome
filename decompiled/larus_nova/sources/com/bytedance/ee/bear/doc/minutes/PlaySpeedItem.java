package com.bytedance.ee.bear.doc.minutes;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/doc/minutes/PlaySpeedItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "isSelect", "", "()Z", "setSelect", "(Z)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaySpeedItem implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f217976id;
    private boolean isSelect;
    private String value;

    public PlaySpeedItem() {
        this.value = "";
    }

    public final int getId() {
        return this.f217976id;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setId(int r100) {
        this.f217976id = r100;
    }

    public final void setSelect(boolean r100) {
        this.isSelect = r100;
    }

    public final void setValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.value = r100;
    }
}
