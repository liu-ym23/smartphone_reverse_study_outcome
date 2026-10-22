package com.obric.aivoice.sdk.data;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelType;", "", "typedName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypedName", "()Ljava/lang/String;", "setTypedName", "(Ljava/lang/String;)V", NameKeys.ModelType_TextEmbedding, "ImageEmbedding", NameKeys.ModelType_SlmService, "Unknown", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ModelType extends Enum<ModelType> {
    private static final /* synthetic */ ModelType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ModelType ImageEmbedding = null;
    public static final ModelType Slm = null;
    public static final ModelType TextEmbedding = null;
    public static final ModelType Unknown = null;
    private String typedName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelType$Companion;", "", "()V", "fromName", "Lcom/obric/aivoice/sdk/data/ModelType;", "name", "", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ModelType fromName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            ModelType[] r101 = ModelType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ModelType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getTypedName(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ ModelType[] $values() {
        return new ModelType[]{TextEmbedding, ImageEmbedding, Slm, Unknown};
    }

    public static ModelType valueOf(String r100) {
        return (ModelType) a.a(ModelType.class, r100);
    }

    public static ModelType[] values() {
        return (ModelType[]) $VALUES.clone();
    }

    static {
        TextEmbedding = new ModelType(NameKeys.ModelType_TextEmbedding, 0, NameKeys.ModelType_TextEmbedding);
        ImageEmbedding = new ModelType("ImageEmbedding", 1, NameKeys.ModelType_ImgEmbedding);
        Slm = new ModelType(NameKeys.ModelType_SlmService, 2, NameKeys.ModelType_SlmService);
        Unknown = new ModelType("Unknown", 3, "");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getTypedName() {
        return this.typedName;
    }

    public final void setTypedName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.typedName = r100;
    }

    private ModelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typedName = r102;
    }
}
