package ei9;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.list.arch.FlowListAdapter;
import com.larus.list.arch.IFlowListCell;
import com.larus.nova.R;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final Fragment b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.tag_key_fragment);
        if ((r101 instanceof Fragment) == true) goto L5;
        Object r102 = r100.getParent();
    L7:
        if (r102 == null) goto L17;
        if ((r102 instanceof View) == false) goto L17;
        if (Intrinsics.areEqual(r102, r100) == true) goto L17;
        View r103 = (View) r102;
        Object r104 = r103.getTag(R.id.tag_key_fragment);
        if ((r104 instanceof Fragment) == true) goto L15;
        r102 = r103.getParent();
        goto L7
    L15:
        return (Fragment) r104;
    L17:
        Context r105 = r100.getContext();
        if ((r105 instanceof FragmentActivity) == false) goto L20;
        FragmentActivity r106 = (FragmentActivity) r105;
    L21:
        if (r106 != null) goto L24;
        return null;
    L24:
        return d(r106.getSupportFragmentManager(), r100);
    L20:
        r106 = null;
        goto L21
    L5:
        return (Fragment) r101;
    }

    public static final ParameterizedType c(Class<?> r100) {
        Type r101 = r100.getGenericSuperclass();
        if ((r101 instanceof ParameterizedType) == false) goto L7;
        return (ParameterizedType) r101;
    L7:
        if (r100.getSuperclass() != null) goto L9;
        return null;
    L9:
        return c(r100.getSuperclass());
    }

    public static final Fragment d(FragmentManager r100, View r101) {
        int r102 = r100.getFragments().size();
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L22;
        Fragment r103 = (Fragment) ListProtector.get(r100.getFragments(), r102);
        View r104 = r103.getView();
        if (r104 == null) goto L3;
        Fragment r105 = d(r103.getChildFragmentManager(), r101);
        if (r105 != null) goto L10;
        Object r106 = r101.getParent();
    L12:
        if (r106 == null) goto L19;
        if ((r106 instanceof View) == false) goto L19;
        if (Intrinsics.areEqual(r106, r104) == true) goto L19;
        r106 = ((View) r106).getParent();
    L19:
        if (Intrinsics.areEqual(r106, r104) == false) goto L3;
        return r103;
    L10:
        return r105;
    L22:
        return null;
    }

    public static final void a(FlowListAdapter<? extends f> r100, Class<? extends IFlowListCell<?>> r110, g<?, ? extends f> r111, hi9.a<? extends f> r112) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "cellType");
        Intrinsics.checkNotNullParameter(r111, "transformer");
        ParameterizedType r101 = c(r110);
        Object r102 = null;
        if (r101 == null) goto L5;
        Type[] r103 = r101.getActualTypeArguments();
    L6:
        boolean r104 = true;
        int r105 = 0;
        if (r103 != null) goto L9;
    L15:
        if (r104 == true) goto L46;
        int r106 = r103.length;
        Class r107 = null;
    L17:
        if (r105 >= r106) goto L27;
        Type r108 = r103[r105];
        if ((r108 instanceof Class) == false) goto L21;
        Class r109 = (Class) r108;
    L22:
        if (r109 == null) goto L26;
        if (f.class.isAssignableFrom(r109) == false) goto L26;
        r107 = r109;
    L26:
        r105 = r105 + 1;
        goto L17
    L21:
        r109 = null;
        goto L22
    L27:
        if (r107 == null) goto L44;
        if (r112 != null) goto L30;
        r112 = null;
    L30:
        fi9.a r113 = (fi9.a) r100.f355728e.getValue();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r107, "stateClazz");
        Intrinsics.checkNotNullParameter(r110, "cellType");
        Intrinsics.checkNotNullParameter(r111, "transformer");
        Iterator r114 = ((ArrayList) r113.f477422a).iterator();
    L32:
        if (r114.hasNext() == false) goto L36;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((fi9.a.C5914a) r115).f477424b.getName(), r110.getName()) == false) goto L32;
        r102 = r115;
    L36:
        if (r102 != null) goto L54;
        List<fi9.a.C5914a> r116 = r113.f477422a;
        if (r112 != null) goto L41;
        r112 = new fi9.b();
    L41:
        ((ArrayList) r116).add(new fi9.a.C5914a(r107, r110, r111, r112));
        return;
    L54:
        return;
    L44:
        throw new IllegalArgumentException("Invalid state class.");
    L46:
        throw new IllegalArgumentException("Cell type actualTypeArguments is empty.");
    L9:
        if (r103.length != 0) goto L11;
        boolean r117 = true;
    L12:
        if (r117 == true) goto L15;
        r104 = false;
        goto L15
    L11:
        r117 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
