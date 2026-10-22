package com.obric.oui.tag;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "use OTextTag")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/tag/ORightIconTagNew;", "Lcom/obric/oui/tag/OTagNew;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ORightIconTagNew extends OTagNew {
    @Override // com.obric.oui.tag.OTagNew, com.obric.oui.button.OButton, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.tag.OTagNew, com.obric.oui.button.OButton
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    public ORightIconTagNew(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ORightIconTagNew(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
    }
}
