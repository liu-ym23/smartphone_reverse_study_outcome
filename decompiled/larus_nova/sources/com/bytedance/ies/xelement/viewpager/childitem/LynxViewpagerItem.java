package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s86.f;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-viewpager-item-pro", "x-viewpager-item", "x-viewpager-item-ng"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.viewpager.childitem")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0007\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxViewpagerItem;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Ls86/f;", "", "tag", "", "setTag", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class LynxViewpagerItem extends UIGroup<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f250532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f250533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f250534c;

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    static {
    }

    public LynxViewpagerItem(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        return new f(r100, this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L6;
        this.f250534c = r100.containsKey(com.lynx.xelement.viewpager.childitem.LynxViewpagerItem.BIND_ON_ATTACH);
        return;
    }

    @LynxProp(name = "tag")
    public final void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f250532a = r100;
        b r101 = this.f250533b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public LynxViewpagerItem(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public final void M(boolean r100, int r101) {
        if (this.f250534c == true) goto L5;
        return;
    L5:
        EventEmitter r102 = getLynxContext().getEventEmitter();
        m7a.a r103 = new m7a.a(getSign(), com.lynx.xelement.viewpager.childitem.LynxViewpagerItem.BIND_ON_ATTACH);
        r103.a(com.lynx.xelement.viewpager.childitem.LynxViewpagerItem.BIND_ON_ATTACH, Boolean.valueOf(r100));
        r103.a("tag", String.valueOf(this.f250532a));
        r103.a("index", Integer.valueOf(r101));
        r102.sendCustomEvent(r103);
    }
}
