package com.bytedance.dux.vacant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.dux.button.DuxButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/dux/vacant/DuxVacantActionView;", "Landroid/widget/LinearLayout;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setIcon", "Lcom/bytedance/dux/button/DuxButton;", "getActionButton", "Landroid/widget/TextView;", "getTitleView", "Landroid/widget/ImageView;", "getIconView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxVacantActionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f205860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxButton f205862c;

    public static final class a {
    }

    static {
    }

    public final DuxButton getActionButton() {
        return this.f205862c;
    }

    public final ImageView getIconView() {
        return this.f205860a;
    }

    public final TextView getTitleView() {
        return this.f205861b;
    }

    public DuxVacantActionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setIcon(Drawable r100) {
        this.f205860a.setImageDrawable(r100);
    }

    public DuxVacantActionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout.inflate(r100, R.layout.dux_vacant_action_view, this);
        setOrientation(1);
        setGravity(1);
        this.f205860a = (ImageView) findViewById(R.id.iv_icon);
        this.f205861b = (TextView) findViewById(R.id.tv_title);
        this.f205862c = (DuxButton) findViewById(R.id.btn_action);
    }
}
