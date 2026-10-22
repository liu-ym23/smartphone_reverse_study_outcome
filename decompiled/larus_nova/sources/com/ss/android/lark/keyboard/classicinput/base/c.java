package com.ss.android.lark.keyboard.classicinput.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, IInputSupportAdditionPlugin> f428680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f428681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<IInputSupportAdditionPlugin, String>> f428682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<IInputSupportAdditionPlugin.OnPanelChangeListener, Object> f428683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SlidingUpPanelLayout f428684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f428685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Activity f428686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f428687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C5083c f428689j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f428691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IInputSupportAdditionPlugin.a f428692c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f428690a, r101.f428690a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f428691b, r101.f428691b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f428692c, r101.f428692c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f428690a.hashCode() * 31) + this.f428691b.hashCode()) * 31) + this.f428692c.hashCode();
        }

        public final String toString() {
            return "PluginEnv(name=" + this.f428690a + ", container=" + this.f428691b + ", context=" + this.f428692c + ')';
        }

        public final IInputSupportAdditionPlugin.a getContext() {
            return this.f428692c;
        }

        public b(String r100, ViewGroup r101, IInputSupportAdditionPlugin.a r102) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f428690a = r100;
            this.f428691b = r101;
            this.f428692c = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.classicinput.base.c$c, reason: collision with other inner class name */
    public static final class C5083c implements SlidingUpPanelLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f428693a;

        @Override // com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout.d
        public final void a() {
            Iterator r100 = ((HashMap) this.f428693a.f428683d).entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r100.next()).getKey()).a();
            goto L4
        }

        public C5083c(c r100) {
            this.f428693a = r100;
        }

        @Override // com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout.d
        public final void b(SlidingUpPanelLayout.PanelState r100, SlidingUpPanelLayout.PanelState r101) {
            SlidingUpPanelLayout.PanelState r102 = SlidingUpPanelLayout.PanelState.COLLAPSED;
            if (r101 != r102) goto L10;
            SlidingUpPanelLayout r103 = this.f428693a.f428684e;
            if (r103 == null) goto L7;
            r103.setEnabled(false);
        L7:
            View r104 = this.f428693a.f428685f;
            if (r104 == null) goto L10;
            r104.setClickable(false);
        L10:
            if (r100 != r102) goto L22;
            SlidingUpPanelLayout r105 = this.f428693a.f428684e;
            if (r105 == null) goto L14;
            r105.setEnabled(true);
        L14:
            View r106 = this.f428693a.f428685f;
            if (r106 == null) goto L17;
            r106.setClickable(true);
        L17:
            Iterator r107 = ((HashMap) this.f428693a.f428683d).entrySet().iterator();
        L19:
            if (r107.hasNext() == false) goto L22;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r107.next()).getKey()).b();
        L22:
            if (r100 != SlidingUpPanelLayout.PanelState.EXPANDED) goto L28;
            Iterator r108 = ((HashMap) this.f428693a.f428683d).entrySet().iterator();
        L25:
            if (r108.hasNext() == false) goto L28;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r108.next()).getKey()).b();
        L28:
            if (r101 != SlidingUpPanelLayout.PanelState.COLLAPSED) goto L34;
            Iterator r109 = ((HashMap) this.f428693a.f428683d).entrySet().iterator();
        L31:
            if (r109.hasNext() == false) goto L34;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r109.next()).getKey()).c();
        L34:
            if (r101 != SlidingUpPanelLayout.PanelState.EXPANDED) goto L39;
            Iterator r110 = ((HashMap) this.f428693a.f428683d).entrySet().iterator();
        L37:
            if (r110.hasNext() == false) goto L44;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r110.next()).getKey()).c();
            goto L37
        L44:
            return;
        }
    }

    static {
    }

    public c() {
        this.f428680a = new HashMap();
        this.f428681b = new HashMap();
        this.f428682c = new ArrayList();
        this.f428683d = new HashMap();
        this.f428687h = 2;
        this.f428689j = new C5083c(this);
    }
}
