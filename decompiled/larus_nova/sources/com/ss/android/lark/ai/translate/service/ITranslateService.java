package com.ss.android.lark.ai.translate.service;

import android.app.Dialog;
import android.content.Context;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import oua.b;

/* JADX INFO: loaded from: classes34.dex */
public interface ITranslateService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/ai/translate/service/ITranslateService$HyperTranslateScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IM_CARD", "DOC_FEED", "DOC_WEB", "APP_SCHEDULE", "Companion", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HyperTranslateScene extends Enum<HyperTranslateScene> {
        public static final HyperTranslateScene APP_SCHEDULE = null;
        public static final a Companion = null;
        public static final HyperTranslateScene DOC_FEED = null;
        public static final HyperTranslateScene DOC_WEB = null;
        public static final HyperTranslateScene IM_CARD = null;
        public static final HyperTranslateScene UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HyperTranslateScene[] f408638a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f408639b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<HyperTranslateScene> getEntries() {
            return f408639b;
        }

        static {
            HyperTranslateScene r100 = new HyperTranslateScene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            HyperTranslateScene r101 = new HyperTranslateScene("IM_CARD", 1, 1);
            IM_CARD = r101;
            HyperTranslateScene r102 = new HyperTranslateScene("DOC_FEED", 2, 2);
            DOC_FEED = r102;
            HyperTranslateScene r103 = new HyperTranslateScene("DOC_WEB", 3, 3);
            DOC_WEB = r103;
            HyperTranslateScene r104 = new HyperTranslateScene("APP_SCHEDULE", 4, 4);
            APP_SCHEDULE = r104;
            HyperTranslateScene[] r105 = {r100, r101, r102, r103, r104};
            f408638a = r105;
            f408639b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static HyperTranslateScene[] values() {
            return (HyperTranslateScene[]) f408638a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static HyperTranslateScene valueOf(String r100) {
            return (HyperTranslateScene) r27.a.a(HyperTranslateScene.class, r100);
        }

        public HyperTranslateScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/ai/translate/service/ITranslateService$TranslateFeedbackScene;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "MESSAGE", "IMAGE", "HYPER", "DOCS", CommonConstant.RETKEY.EMAIL, "MOMENTS", "CHAT_NAME", "Companion", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TranslateFeedbackScene extends Enum<TranslateFeedbackScene> {
        public static final TranslateFeedbackScene CHAT_NAME = null;
        public static final a Companion = null;
        public static final TranslateFeedbackScene DOCS = null;
        public static final TranslateFeedbackScene EMAIL = null;
        public static final TranslateFeedbackScene HYPER = null;
        public static final TranslateFeedbackScene IMAGE = null;
        public static final TranslateFeedbackScene MESSAGE = null;
        public static final TranslateFeedbackScene MOMENTS = null;
        public static final TranslateFeedbackScene UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TranslateFeedbackScene[] f408640a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f408641b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TranslateFeedbackScene> getEntries() {
            return f408641b;
        }

        static {
            TranslateFeedbackScene r100 = new TranslateFeedbackScene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TranslateFeedbackScene r101 = new TranslateFeedbackScene("MESSAGE", 1, 1);
            MESSAGE = r101;
            TranslateFeedbackScene r102 = new TranslateFeedbackScene("IMAGE", 2, 2);
            IMAGE = r102;
            TranslateFeedbackScene r103 = new TranslateFeedbackScene("HYPER", 3, 3);
            HYPER = r103;
            TranslateFeedbackScene r104 = new TranslateFeedbackScene("DOCS", 4, 4);
            DOCS = r104;
            TranslateFeedbackScene r105 = new TranslateFeedbackScene(CommonConstant.RETKEY.EMAIL, 5, 5);
            EMAIL = r105;
            TranslateFeedbackScene r110 = new TranslateFeedbackScene("MOMENTS", 6, 7);
            MOMENTS = r110;
            TranslateFeedbackScene r111 = new TranslateFeedbackScene("CHAT_NAME", 7, 8);
            CHAT_NAME = r111;
            TranslateFeedbackScene[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f408640a = r112;
            f408641b = EnumEntriesKt.enumEntries(r112);
            Companion = new a();
        }

        public static TranslateFeedbackScene[] values() {
            return (TranslateFeedbackScene[]) f408640a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static TranslateFeedbackScene valueOf(String r100) {
            return (TranslateFeedbackScene) r27.a.a(TranslateFeedbackScene.class, r100);
        }

        public TranslateFeedbackScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    void showHyperTranslateDialog(Context r100, String r101, HyperTranslateScene r102, b r103);

    Dialog showTranslateFeedbackDialog(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, TranslateFeedbackScene r108, b r110, Map<String, String> r111);
}
