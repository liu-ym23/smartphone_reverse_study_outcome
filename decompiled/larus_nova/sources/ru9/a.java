package ru9;

import com.google.gson.annotations.SerializedName;
import com.larus.settings.provider.feature.data.FeatureModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR \u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR \u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/feature/FeatureConfigProvider;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "<init>", "()V", "create", "answerWithSuggest", "Lcom/larus/settings/provider/feature/data/FeatureModel;", "getAnswerWithSuggest", "()Lcom/larus/settings/provider/feature/data/FeatureModel;", "setAnswerWithSuggest", "(Lcom/larus/settings/provider/feature/data/FeatureModel;)V", "inputWithSuggest", "getInputWithSuggest", "setInputWithSuggest", "answerWithVideo", "getAnswerWithVideo", "setAnswerWithVideo", "namedEntityHighlight", "getNamedEntityHighlight", "setNamedEntityHighlight", "settingDebug", "getSettingDebug", "setSettingDebug", "messageDebug", "getMessageDebug", "setMessageDebug", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("answer_with_suggest")
    private FeatureModel answerWithSuggest;

    @SerializedName("answer_with_video")
    private FeatureModel answerWithVideo;

    @SerializedName("input_with_suggest")
    private FeatureModel inputWithSuggest;

    @SerializedName("message_debug")
    private FeatureModel messageDebug;

    @SerializedName("named_entity_highlight")
    private FeatureModel namedEntityHighlight;

    @SerializedName("setting_debug")
    private FeatureModel settingDebug;

    public a() {
    }
}
