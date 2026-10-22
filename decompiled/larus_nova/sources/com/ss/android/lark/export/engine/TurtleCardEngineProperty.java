package com.ss.android.lark.export.engine;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.export.entity.turtle.TurtleCanvasEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/engine/TurtleCardEngineProperty;", "Lcom/ss/android/lark/export/engine/EngineProperty;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", ContainerPosition.BODY, "Lokio/ByteString;", "turtleContent", "Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "<init>", "(Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;Lokio/ByteString;Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;)V", "getTurtleContent", "()Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TurtleCardEngineProperty extends EngineProperty {
    private final TurtleCanvasEntity turtleContent;

    public TurtleCardEngineProperty() {
        this(null, null, null, 7, null);
    }

    public final TurtleCanvasEntity getTurtleContent() {
        return this.turtleContent;
    }

    public TurtleCardEngineProperty(EngineProperty.EngineType r100, ByteString r101, TurtleCanvasEntity r102) {
        Intrinsics.checkNotNullParameter(r100, "engineType");
        super(r100, r101);
        this.turtleContent = r102;
    }

    public /* synthetic */ TurtleCardEngineProperty(EngineProperty.EngineType r100, ByteString r101, TurtleCanvasEntity r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = EngineProperty.EngineType.TURTLE_CANVAS;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
