package c08;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.list.iconitem.IconItemView;
import com.larksuite.component.ui.tag.TagsDrawable;
import com.larksuite.component.ui.tag.e;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements b08.b<IconItemView, d> {
    public c() {
    }

    @Override // b08.b
    public final void unbind(View r2) {
        IconItemView r3 = (IconItemView) r2;
        Intrinsics.checkNotNullParameter(r3, "view");
        TextView r4 = r3.d;
        if (r4 == null) goto L6;
        r4.setVisibility(8);
        return;
    }

    @Override // b08.b
    public final void bind(View r11, d r12) {
        IconItemView r13 = (IconItemView) r11;
        d r14 = r12;
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "model");
        TextView r0 = r13.d;
        r0.setVisibility(8);
        String r1 = r14.b;
        if (r1 == null) goto L5;
        r0.setText(r1);
        r0.setTextColor(ContextCompat.getColor(r13.getContext(), r14.d));
        r0.setVisibility(0);
    L5:
        Context r15 = r13.getContext();
        Intrinsics.checkNotNull(r15);
        TagsDrawable.a r2 = new TagsDrawable.a(r15);
        if (r14.c == false) goto L15;
        TagsDrawable.d.a r3 = new TagsDrawable.d.a(r15);
        r3.c = 100;
        Drawable r5 = AppCompatResources.getDrawable(r15, 2131238051);
        if (r5 != null) goto L11;
    L14:
        TagsDrawable.d r6 = new TagsDrawable.d(r3);
        Intrinsics.checkNotNullParameter(r6, "tag");
        ((ArrayList) r2.g).add(r6);
        r0.setVisibility(0);
        goto L15
    L11:
        if ((r5 instanceof UDTagsDrawable) == false) goto L13;
        r3.e = r5;
        goto L14
    L13:
        r3.e = new TagsDrawable.c(r5);
    L15:
        Drawable r16 = r14.a;
        if (r16 == null) goto L22;
        TagsDrawable.d.a r4 = new TagsDrawable.d.a(r15);
        r4.c = 0;
        if ((r16 instanceof UDTagsDrawable) == false) goto L20;
        r4.e = r16;
    L21:
        TagsDrawable.d r17 = new TagsDrawable.d(r4);
        Intrinsics.checkNotNullParameter(r17, "tag");
        ((ArrayList) r2.g).add(r17);
        r0.setVisibility(0);
        goto L22
    L20:
        r4.e = new TagsDrawable.c(r16);
    L22:
        ArrayList r19 = (ArrayList) r2.g;
        if (r19.size() <= 1) goto L25;
        CollectionsKt.sortWith(r19, new e());
    L25:
        HashSet r110 = new HashSet();
        int r111 = r2.h.size();
        List<TagsDrawable.d> r7 = r2.g;
        ArrayList r8 = new ArrayList();
        Iterator r9 = ((ArrayList) r7).iterator();
    L27:
        if (r9.hasNext() == false) goto L40;
        Object r10 = r9.next();
        TagsDrawable.d r20 = (TagsDrawable.d) r10;
        boolean r21 = r110.contains(Integer.valueOf(r20.a));
        if (r21 == true) goto L38;
        if (r111 <= 0) goto L38;
        Iterator<HashSet<Integer>> r22 = r2.h.iterator();
    L33:
        if (r22.hasNext() == false) goto L38;
        HashSet<Integer> r23 = r22.next();
        if (r23.contains(Integer.valueOf(r20.a)) == false) goto L33;
        r110.addAll(r23);
        r111 = r111 - 1;
    L38:
        if ((!r21) == false) goto L27;
        r8.add(r10);
        goto L27
    L40:
        ((ArrayList) r2.g).clear();
        ((ArrayList) r2.g).addAll(r8);
        if (((ArrayList) r2.g).isEmpty() == false) goto L43;
        TagsDrawable r112 = null;
    L44:
        r0.setCompoundDrawables(null, null, r112, null);
        return;
    L43:
        r112 = new TagsDrawable(r2);
        goto L44
    }
}
