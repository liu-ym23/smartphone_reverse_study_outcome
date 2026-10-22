package com.bytedance.ee.bear.bitable.uikit.fieldcell.pure;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableUserUikitItemBinding;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.IconCapsuleModel;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/pure/UserItemView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cache", "getCache", "()Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;", "setCache", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableUserUikitItemBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableUserUikitItemBinding;", "getContentView", "Landroid/widget/TextView;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserItemView extends LinearLayout implements b<IconCapsuleModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IconCapsuleModel f216203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableUserUikitItemBinding f216204b;

    public UserItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TextView getContentView() {
        return this.f216204b.f211065c;
    }

    public final BitableUserUikitItemBinding getBinding() {
        return this.f216204b;
    }

    public final IconCapsuleModel getCache() {
        return this.f216203a;
    }

    public final void setCache(IconCapsuleModel r100) {
        this.f216203a = r100;
    }

    public UserItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.bitable_user_uikit_item, this);
        int r103 = R.id.user_avatar;
        UDAvatar r104 = (UDAvatar) ViewBindings.findChildViewById(this, R.id.user_avatar);
        if (r104 == null) goto L9;
        r103 = R.id.user_name;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.user_name);
        if (r105 == null) goto L9;
        this.f216204b = new BitableUserUikitItemBinding(this, r104, r105);
        setBackground(getResources().getDrawable(R.drawable.bitable_card_user_item_bg));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ UserItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
