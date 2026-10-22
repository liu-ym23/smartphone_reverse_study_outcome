package iy8;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f496575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f496576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f496577c;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f496576b = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_50, r100, R.color.larus_primary_50));
        this.f496577c = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100));
        FrameLayout.inflate(r100, R.layout.larus_item_actionbar_feature_selector, this);
        this.f496575a = (TextView) findViewById(R.id.tv_feature_item);
    }
}
