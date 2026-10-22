package com.ss.android.lark.export.engine.smartcard;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/engine/smartcard/SmartCardEngineProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "engineType", "Lcom/ss/android/lark/export/parser/ModelParserRenderRouterEntity$CardEngineType;", ContainerPosition.BODY, "Lokio/ByteString;", "<init>", "(Lcom/ss/android/lark/export/parser/ModelParserRenderRouterEntity$CardEngineType;Lokio/ByteString;)V", "getEngineType", "()Lcom/ss/android/lark/export/parser/ModelParserRenderRouterEntity$CardEngineType;", "getBody", "()Lokio/ByteString;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SmartCardEngineProperty extends BaseProperty {
    private final ByteString body;
    private final ModelParserRenderRouterEntity.CardEngineType engineType;

    /* JADX WARN: Multi-variable type inference failed */
    public SmartCardEngineProperty() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final ByteString getBody() {
        return this.body;
    }

    public final ModelParserRenderRouterEntity.CardEngineType getEngineType() {
        return this.engineType;
    }

    public SmartCardEngineProperty(ModelParserRenderRouterEntity.CardEngineType r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r100, "engineType");
        super(Type.ENGINE);
        this.engineType = r100;
        this.body = r101;
    }

    public /* synthetic */ SmartCardEngineProperty(ModelParserRenderRouterEntity.CardEngineType r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
