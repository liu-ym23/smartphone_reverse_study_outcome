package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/obric/oui/avatar/OAvatar;", "getAvatars", "Landroid/graphics/drawable/Drawable;", "drawables", "", "setAvatars", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OAvatarQueueView extends ConstraintLayout {
    public final List<OAvatar> getAvatars() {
        ArrayList r100 = new ArrayList();
        Iterator<View> r101 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        View r102 = r101.next();
        if ((r102 instanceof OAvatar) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public OAvatarQueueView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAvatars(List<? extends Drawable> r100) {
        Intrinsics.checkNotNullParameter(r100, "drawables");
        int r101 = 0;
        Iterator<T> r102 = r100.subList(0, 5).iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        int r104 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Drawable r105 = (Drawable) r103;
        View r106 = getChildAt(r101);
        if (r106 == null) goto L12;
        ((OAvatar) r106).getContentImageView().setImageDrawable(r105);
        r101 = r104;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
    }

    public OAvatarQueueView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_widget_avatar_queue, this);
    }
}
