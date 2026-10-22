package com.suite.lark.platform.feature.forward.doubao.api;

import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/ForwardDoubaoExecutorExtra;", "Ljava/io/Serializable;", "<init>", "()V", "scene", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;", "getScene", "()Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;", "setScene", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;)V", "content", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;", "getContent", "()Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;", "setContent", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;)V", "note", "", "getNote", "()Ljava/lang/String;", "setNote", "(Ljava/lang/String;)V", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardDoubaoExecutorExtra implements Serializable {
    private ForwardDoubaoContent content;
    private String note;
    private ForwardScene scene;

    public ForwardDoubaoExecutorExtra() {
        this.scene = ForwardScene.UNKNOWN;
        this.content = new ForwardDoubaoContent();
        this.note = "";
    }

    public final ForwardDoubaoContent getContent() {
        return this.content;
    }

    public final String getNote() {
        return this.note;
    }

    public final ForwardScene getScene() {
        return this.scene;
    }

    public final void setContent(ForwardDoubaoContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setNote(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.note = r100;
    }

    public final void setScene(ForwardScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }
}
