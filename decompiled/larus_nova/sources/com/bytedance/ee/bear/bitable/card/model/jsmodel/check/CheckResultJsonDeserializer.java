package com.bytedance.ee.bear.bitable.card.model.jsmodel.check;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/check/CheckResultJsonDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/check/CheckResult;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckResultJsonDeserializer implements JsonDeserializer<CheckResult> {
    public CheckResultJsonDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final CheckResult deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        NonProguard r103 = null;
        if (r100 == null) goto L29;
        if (r102 == null) goto L30;
        JsonObject r104 = r100.getAsJsonObject();
        String r105 = r104.get("type").getAsString();
        JsonElement r106 = r104.get("extra");
        if (Intrinsics.areEqual(r105, CheckType.ConfirmConvertModifiedTime.getValue()) == false) goto L10;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmConvertModifiedTimeExtra.class);
    L27:
        CheckResult r107 = new CheckResult();
        r107.setType(r105);
        r107.setExtra(r103);
        return r107;
    L10:
        if (Intrinsics.areEqual(r105, CheckType.ConfirmConvertType.getValue()) == false) goto L13;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmConvertTypeExtra.class);
        goto L27
    L13:
        if (Intrinsics.areEqual(r105, CheckType.ConfirmKeepNoExistData.getValue()) == false) goto L16;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmKeepNoExistDataExtra.class);
        goto L27
    L16:
        if (Intrinsics.areEqual(r105, CheckType.ConfirmExtendFieldDelete.getValue()) == false) goto L19;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmExtendFieldDeleteExtra.class);
        goto L27
    L19:
        if (Intrinsics.areEqual(r105, CheckType.SetFieldAttr.getValue()) == false) goto L22;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmSetFieldAttrExtra.class);
        goto L27
    L22:
        if (Intrinsics.areEqual(r105, CheckType.ConfirmAIFieldTypeChange.getValue()) == false) goto L25;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmFieldTypeChangeExtra.class);
        goto L27
    L25:
        if (Intrinsics.areEqual(r105, CheckType.ConfirmAIGenerate.getValue()) == false) goto L27;
        r103 = (NonProguard) r102.deserialize(r106, ConfirmAIGenerateExtra.class);
        goto L27
    L30:
        return null;
    L29:
        return null;
    }
}
