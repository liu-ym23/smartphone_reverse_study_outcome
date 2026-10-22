package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.Gson;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.utils.k;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListLynxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/personlist/PersonListTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "createView", "Landroid/content/Context;", "updateExtraData", "", ControlRule.KEY_EXTRA_DATA, "", "setContent", SlcElement.KEY_PROPS, "Lcom/lynx/react/bridge/ReadableMap;", "loadAvatarIfNeed", "personListProp", "Lcom/larksuite/component/card/component/personlist/PersonListProps;", "initLongClickListener", "dispatchEvent", "", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "enableCopy", "textView", "cardShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "Companion", "ClickMoreListener", "ClickPersonListener", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PersonListLynxUI extends LynxUI<PersonListTextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283418a = 0;

    public static final class a implements com.larksuite.component.card.component.personlist.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rcc.a f283419a;

        public a() {
            this.f283419a = new rcc.a();
        }

        @Override // com.larksuite.component.card.component.personlist.a
        public final void a(FragmentActivity r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "personList");
            if (this.f283419a.a() == false) goto L6;
            Log.e("CardPersonListLynxUI", "click more check isDuplicate: " + r101.hashCode());
            return;
        L6:
            wy7.b.b(r100, r101);
        }
    }

    public static final class b implements com.larksuite.component.card.component.personlist.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ShadowNode f283420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ICardDependency f283421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rcc.a f283422c;

        @Override // com.larksuite.component.card.component.personlist.b
        public final void a(String r100) {
            if (this.f283422c.a() == false) goto L7;
            Log.e("CardPersonListLynxUI", "click person check isDuplicate: " + r100);
            return;
        L7:
            if (TextUtils.isEmpty(r100) == false) goto L10;
            Log.e("CardPersonListLynxUI", "userId is empty");
            return;
        L10:
            ICardDependency r101 = this.f283421b;
            if (r101 == null) goto L14;
            if (r100 == null) goto L18;
            r101.openProfilePage(this.f283420a.getContext(), r100, "");
            return;
        L18:
            return;
        L14:
            yy7.a r102 = ty7.a.a();
            if (r102 == null) goto L20;
            r102.showProfile(this.f283420a.getContext(), r100);
            return;
        }

        public b(ShadowNode r100, ICardDependency r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            this.f283420a = r100;
            this.f283421b = r101;
            this.f283422c = new rcc.a();
        }
    }

    public static final class c {
    }

    static {
    }

    public PersonListLynxUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public static final /* synthetic */ View M(PersonListLynxUI r100) {
        return r100.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PersonListTextView r101 = new PersonListTextView(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return r101;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchEvent(LynxEventDetail r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f383319a.getName();
    L6:
        if (TextUtils.equals(r101, "tap") == false) goto L10;
        return true;
    L10:
        return super.dispatchEvent(r100);
    L4:
        r101 = null;
        goto L6
    }

    @LynxProp(name = SlcElement.KEY_PROPS)
    public final void setContent(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        TraceEvent.beginSection("PersonListLynxUI.setContent");
        Integer r101 = null;
        Gson r102 = com.larksuite.component.card.component.g.f283368a;     // Catch: Throwable -> L5
        PersonListProps r103 = (PersonListProps) com.larksuite.component.card.component.g.c(r100, PersonListProps.class);     // Catch: Throwable -> L5
    L7:
        if (r103 != null) goto L10;
        Log.e("CardPersonListLynxUI", "setContent fail, content is empty");
        return;
    L10:
        Integer r104 = r103.getLines();
        if (r104 != null) goto L13;
    L20:
        ((PersonListTextView) this.mView).setMaxLines(Integer.MAX_VALUE);
    L21:
        TextPaint r105 = ((PersonListTextView) this.mView).getPaint();
        g.f283510a.getClass();
        r105.setTextSize(g.h(r103));
        ((PersonListTextView) this.mView).getPaint().setColor(g.g(r103));
        ((PersonListTextView) this.mView).setOnLongClickListener(new d(this));
        if (r103.getShowAvatar() == false) goto L40;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r103.getPersons().iterator();
    L26:
        if (r107.hasNext() == false) goto L38;
        PersonInfo r108 = (PersonInfo) r107.next();
        if (k.b(r108.getAvatarKey()) == true) goto L29;
        if (k.b(r108.getId()) == false) goto L26;
        String r109 = r108.getId();
        if (r109 == null) goto L26;
        r106.add(r109);
        goto L26
    L29:
        String r110 = r108.getAvatarKey();
        if (r110 == null) goto L26;
        Lazy<SimpleUserLoader> r111 = SimpleUserLoader.f283460d;
        SimpleUserLoader.a.a().c(r110, new e(this));
        goto L26
    L38:
        if ((!r106.isEmpty()) == false) goto L40;
        Lazy<SimpleUserLoader> r112 = SimpleUserLoader.f283460d;
        SimpleUserLoader.a.a().b(r106, new f(this));
    L40:
        TraceEvent.endSection("PersonListLynxUI.setContent");
        return;
    L13:
        if (r104.intValue() <= 0) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == false) goto L18;
        r101 = r104;
    L18:
        if (r101 == null) goto L20;
        ((PersonListTextView) this.mView).setMaxLines(r101.intValue());
        goto L21
    L15:
        r113 = false;
    L5:
        th = move-exception;
        Log.e("CardPersonListLynxUI", "props from lynx transform failed", th);
        r103 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r100) {
        super.updateExtraData(r100);
        if (r100 != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        ((PersonListTextView) this.mView).setText((CharSequence) r100);
        return;
    L9:
        return;
    L5:
        r101 = r100 instanceof CharSequence;
        goto L6
    }
}
