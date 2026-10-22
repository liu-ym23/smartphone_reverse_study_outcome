package com.ss.android.lark.export.parser;

import com.bytedance.lark.pb.basic.v1.CardComponent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class ModelParserRenderRouterEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420715a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/export/parser/ModelParserRenderRouterEntity$CardEngineType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNIVERSAL_CARD", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardEngineType extends Enum<CardEngineType> {
        public static final a Companion = null;
        public static final CardEngineType UNIVERSAL_CARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardEngineType[] f420716a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420717b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CardEngineType> getEntries() {
            return f420717b;
        }

        static {
            CardEngineType r100 = new CardEngineType();
            UNIVERSAL_CARD = r100;
            CardEngineType[] r101 = {r100};
            f420716a = r101;
            f420717b = EnumEntriesKt.enumEntries(r101);
            Companion = new a();
        }

        public CardEngineType() {
            super("UNIVERSAL_CARD", 0);
            this.value = 0;
        }

        public static CardEngineType[] values() {
            return (CardEngineType[]) f420716a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CardEngineType valueOf(String r100) {
            return (CardEngineType) r27.a.a(CardEngineType.class, r100);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420718a = null;

        static {
            int[] r100 = new int[CardComponent.Type.values().length];
            r100[CardComponent.Type.FLEX_LAYOUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CardComponent.Type.ENGINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f420718a = r100;
        }
    }

    static {
    }
}
