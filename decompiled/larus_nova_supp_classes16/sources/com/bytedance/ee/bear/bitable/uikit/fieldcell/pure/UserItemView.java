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
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/pure/UserItemView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cache", "getCache", "()Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;", "setCache", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableUserUikitItemBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableUserUikitItemBinding;", "getContentView", "Landroid/widget/TextView;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserItemView extends LinearLayout implements b<IconCapsuleModel> {
    public IconCapsuleModel a;
    public final BitableUserUikitItemBinding b;

    public UserItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UserItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final TextView getContentView() {
        return this.b.c;
    }

    public final BitableUserUikitItemBinding getBinding() {
        return this.b;
    }

    public final IconCapsuleModel getCache() {
        return this.a;
    }

    public final void setCache(IconCapsuleModel r1) {
        this.a = r1;
    }

    public UserItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131559190, this);
        int r5 = 2131391990;
        UDAvatar r6 = ViewBindings.findChildViewById(this, 2131391990);
        if (r6 == null) goto L9;
        r5 = 2131392049;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131392049);
        if (r7 == null) goto L9;
        this.b = new BitableUserUikitItemBinding(this, r6, r7);
        setBackground(getResources().getDrawable(2131232243));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ UserItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
