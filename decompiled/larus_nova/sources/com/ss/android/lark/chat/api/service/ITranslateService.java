package com.ss.android.lark.chat.api.service;

import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public interface ITranslateService {

    public static final enum TranslateTriggerType extends Enum<TranslateTriggerType> {
        public static final TranslateTriggerType AUTO = null;
        public static final TranslateTriggerType MANUAL = null;
        public static final TranslateTriggerType SWITCH_LANGUAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TranslateTriggerType[] f411524a = null;

        static {
            TranslateTriggerType r100 = new TranslateTriggerType("MANUAL", 0);
            MANUAL = r100;
            TranslateTriggerType r101 = new TranslateTriggerType("AUTO", 1);
            AUTO = r101;
            TranslateTriggerType r102 = new TranslateTriggerType("SWITCH_LANGUAGE", 2);
            SWITCH_LANGUAGE = r102;
            f411524a = new TranslateTriggerType[]{r100, r101, r102};
        }

        public static TranslateTriggerType[] values() {
            return (TranslateTriggerType[]) f411524a.clone();
        }

        public static TranslateTriggerType valueOf(String r100) {
            return (TranslateTriggerType) a.a(TranslateTriggerType.class, r100);
        }

        public TranslateTriggerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    void L4(String r100, IGetDataCallback<Boolean> r101);

    void W4(boolean r100, Map<String, TranslateUrlPreviewContext> r101, Map<String, Map<String, PreviewHangPoint>> r102, IGetDataCallback<Map<String, Map<String, PreviewHangPoint>>> r103);

    void cb(boolean r100, IGetDataCallback<Boolean> r101);

    void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r100);

    void jf(List<String> r100, TranslateTriggerType r101, String r102, List<MessageSource> r103, String r104, Map<String, Integer> r105, boolean r106, IGetDataCallback<fcb.a> r107);

    void s9(SyncDataStrategy r100, IGetDataCallback<TranslateLanguageSetting> r101);
}
