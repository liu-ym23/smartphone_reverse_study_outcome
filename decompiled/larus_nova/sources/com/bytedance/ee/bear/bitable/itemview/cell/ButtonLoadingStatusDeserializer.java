package com.bytedance.ee.bear.bitable.itemview.cell;

import com.bytedance.ee.bear.bitable.card.viewmodel.cell.BitableCardButtonLoadingStatus;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/ButtonLoadingStatusDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/BitableCardButtonLoadingStatus;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonLoadingStatusDeserializer implements JsonDeserializer<BitableCardButtonLoadingStatus> {
    public ButtonLoadingStatusDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final BitableCardButtonLoadingStatus deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r100.getAsString().toLowerCase(Locale.ROOT);
        switch(r103.hashCode()) {
            case 3089282: goto L21;
            case 270940796: goto L17;
            case 336650556: goto L13;
            case 1544803905: goto L9;
            case 1671308008: goto L6;
            default: goto L25;
        };
    L6:
        if (r103.equals("disable") == false) goto L25;
    L28:
        return BitableCardButtonLoadingStatus.Disabled;
    L9:
        if (r103.equals("default") == false) goto L25;
        return BitableCardButtonLoadingStatus.Default;
    L13:
        if (r103.equals("loading") == false) goto L25;
        return BitableCardButtonLoadingStatus.Loading;
    L17:
        if (r103.equals("disabled") == true) goto L28;
    L21:
        if (r103.equals("done") == false) goto L25;
        return BitableCardButtonLoadingStatus.Done;
    L25:
        return BitableCardButtonLoadingStatus.Default;
    }
}
