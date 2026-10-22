package com.bytedance.assem.arch.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0085\u0001\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2W\b\u0002\u0010\u0011\u001aQ\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010H\u0007J\\\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00132\u0006\u0010\u0007\u001a\u00020\u00062+\b\u0002\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016j\u0004\u0018\u0001`\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/assem/arch/core/AssemContainerBridge;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/content/Intent;", "intent", "", "requestCode", "Landroid/os/Bundle;", "options", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "resultCode", "result", "", "Lcom/bytedance/assem/arch/core/ActivityResult;", "resultCallback", "startActivityForResult", "", "", "permissions", "Lkotlin/Function1;", "", "grantResults", "Lcom/bytedance/assem/arch/core/PermissionResult;", "requestPermissions", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "<init>", "()V", "a", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssemContainerBridge extends Fragment {
    public static final /* synthetic */ int g = 0;
    public final SparseArrayCompat<Function3<Integer, Integer, Intent, Unit>> d;
    public final SparseArrayCompat<Function1<int[], Unit>> e;
    public final Set<Function0<Unit>> f;

    public static final class a {
        @JvmStatic
        public static AssemContainerBridge a(FragmentActivity r4) {
            Fragment r0 = r4.getSupportFragmentManager().findFragmentByTag("AssemContainerBridge");
            if ((r0 instanceof AssemContainerBridge) == true) goto L5;
            r0 = null;
        L5:
            AssemContainerBridge r1 = (AssemContainerBridge) r0;
            if (r1 != null) goto L12;
            r1 = new AssemContainerBridge();
            FragmentTransaction r5 = r4.getSupportFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "AssemContainerBridge", 0) == true) goto L11;
            r5.add(r1, "AssemContainerBridge");
        L11:
            r5.commitAllowingStateLoss();
        L12:
            return r1;
        }
    }

    static {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public AssemContainerBridge() {
        this.d = new SparseArrayCompat();
        this.e = new SparseArrayCompat();
        this.f = new LinkedHashSet();
    }

    public final boolean S90(LifecycleOwner r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        return com.bytedance.assem.arch.extensions.g.a(requireActivity(), r3);
    L7:
        throw new IllegalStateException("This method must be called on main thread".toString());
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Iterator<T> r3 = this.f.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Function0) r3.next()).invoke();
        goto L4
    L6:
        this.f.clear();
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        Function3 r0 = (Function3) this.d.get(r3);
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(r3), Integer.valueOf(r4), r5);
        this.d.remove(r3);
        return;
    }

    public final void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        super.onRequestPermissionsResult(r1, r2, r3);
        Function1 r4 = (Function1) this.e.get(r1);
        if (r4 == null) goto L6;
        r4.invoke(r3);
        this.e.remove(r1);
        return;
    }

    public final void requestPermissions(final LifecycleOwner r2, String[] r3, final int r4, Function1<? super int[], Unit> r5) {
        if (S90(r2) == true) goto L5;
        return;
    L5:
        this.e.put(r4, r5);
        requestPermissions(r3, r4);
        r2.getLifecycle().addObserver(new AnonymousClass1(this, r2, r4));
    }

    public final void startActivityForResult(final LifecycleOwner r2, Intent r3, final int r4, Bundle r5, Function3<? super Integer, ? super Integer, ? super Intent, Unit> r6) {
        if (S90(r2) == true) goto L5;
        return;
    L5:
        if (r4 >= 0) goto L8;
        startActivity(r3);
        return;
    L8:
        this.d.put(r4, r6);
        startActivityForResult(r3, r4, r5);
        r2.getLifecycle().addObserver(new C02121(this, r2, r4));
    }
}
