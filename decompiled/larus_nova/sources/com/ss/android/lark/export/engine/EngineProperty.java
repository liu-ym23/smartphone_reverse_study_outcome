package com.ss.android.lark.export.engine;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Type;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/export/engine/EngineProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", ContainerPosition.BODY, "Lokio/ByteString;", "<init>", "(Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;Lokio/ByteString;)V", "getEngineType", "()Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "getBody", "()Lokio/ByteString;", "EngineType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EngineProperty extends BaseProperty {
    private final ByteString body;
    private final EngineType engineType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MESSAGE", "DOC_COMPONENT", "TURTLE_CANVAS", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EngineType extends Enum<EngineType> {
        public static final a Companion = null;
        public static final EngineType DOC_COMPONENT = null;
        public static final EngineType MESSAGE = null;
        public static final EngineType TURTLE_CANVAS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EngineType[] f420648a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420649b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<EngineType> getEntries() {
            return f420649b;
        }

        static {
            EngineType r100 = new EngineType("MESSAGE", 0, 0);
            MESSAGE = r100;
            EngineType r101 = new EngineType("DOC_COMPONENT", 1, 1);
            DOC_COMPONENT = r101;
            EngineType r102 = new EngineType("TURTLE_CANVAS", 2, 2);
            TURTLE_CANVAS = r102;
            EngineType[] r103 = {r100, r101, r102};
            f420648a = r103;
            f420649b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static EngineType[] values() {
            return (EngineType[]) f420648a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EngineType valueOf(String r100) {
            return (EngineType) r27.a.a(EngineType.class, r100);
        }

        public EngineType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EngineProperty() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final ByteString getBody() {
        return this.body;
    }

    public final EngineType getEngineType() {
        return this.engineType;
    }

    public EngineProperty(EngineType r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r100, "engineType");
        super(Type.ENGINE);
        this.engineType = r100;
        this.body = r101;
    }

    public /* synthetic */ EngineProperty(EngineType r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = EngineType.MESSAGE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
