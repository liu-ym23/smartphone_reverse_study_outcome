package androidx.compose.foundation.gestures;

import android.view.ViewConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/gestures/ViewConfigurationApi26Impl;", "", "<init>", "()V", "getVerticalScrollFactor", "", "viewConfiguration", "Landroid/view/ViewConfiguration;", "getHorizontalScrollFactor", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ViewConfigurationApi26Impl {
    public static final ViewConfigurationApi26Impl INSTANCE = null;

    static {
        INSTANCE = new ViewConfigurationApi26Impl();
    }

    private ViewConfigurationApi26Impl() {
    }

    public final float getHorizontalScrollFactor(ViewConfiguration r1) {
        return r1.getScaledHorizontalScrollFactor();
    }

    public final float getVerticalScrollFactor(ViewConfiguration r1) {
        return r1.getScaledVerticalScrollFactor();
    }
}
