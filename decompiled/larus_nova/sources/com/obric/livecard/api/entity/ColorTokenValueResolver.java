package com.obric.livecard.api.entity;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.obric.livecard.api.ILiveCard;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\f\u0010\u0007\u001a\u00020\b*\u00020\u0006H\u0002J\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/entity/ColorTokenValueResolver;", "", "()V", JSEventListener.ACTION_RESOLVE, "Lcom/obric/livecard/api/entity/ColorHex;", "colorRes", "", "toArgbHex", "", "withNightMode", "Landroid/content/Context;", "nightMode", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColorTokenValueResolver {
    public static final ColorTokenValueResolver INSTANCE = null;

    static {
        INSTANCE = new ColorTokenValueResolver();
    }

    private ColorTokenValueResolver() {
    }

    private final String toArgbHex(int r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r100)}, 1));
    }

    public final ColorHex resolve(int r100) {
        Application r101 = ILiveCard.Companion.getInst().getContext();
        if (r101 == null) goto L7;
        Context r102 = withNightMode(r101, 16);
        Context r103 = withNightMode(r101, 32);
        return new ColorHex(toArgbHex(ContextCompat.getColor(r102, r100)), toArgbHex(ContextCompat.getColor(r103, r100)));
    L7:
        throw new IllegalStateException("ILiveCard.init(context) must be called before creating ColorToken".toString());
    }

    private final Context withNightMode(Context r100, int r101) {
        Configuration r102 = new Configuration(r100.getResources().getConfiguration());
        r102.uiMode = r101 | (r102.uiMode & (-49));
        Context r103 = r100.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r103);
        return r103;
    }
}
