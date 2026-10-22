package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.ai.translate.service.ITranslateService;
import java.util.Map;
import oua.b;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(ITranslateService.class)
public class TranslateServiceMock implements ITranslateService {
    private static final String TAG = "OfficeSdkMock";

    public TranslateServiceMock() {
    }

    public Dialog showHyperTranslateDialog(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, ITranslateService.HyperTranslateScene r107, b r108) {
        return null;
    }

    @Override // com.ss.android.lark.ai.translate.service.ITranslateService
    public void showHyperTranslateDialog(Context r100, String r101, ITranslateService.HyperTranslateScene r102, b r103) {
    }

    public Dialog showTranslateFeedbackDialog(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, ITranslateService.TranslateFeedbackScene r108, b r110) {
        return null;
    }

    @Override // com.ss.android.lark.ai.translate.service.ITranslateService
    public Dialog showTranslateFeedbackDialog(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, ITranslateService.TranslateFeedbackScene r108, b r110, Map<String, String> r111) {
        return null;
    }
}
