package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u001a0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerTabFragment;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment;", "<init>", "()V", "listener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerTabFragment$ColorPickerListener;", "getListener", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerTabFragment$ColorPickerListener;", "setListener", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerTabFragment$ColorPickerListener;)V", "itemData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "update", "", WikiFolderPushPlugin.DATA, "contentLayoutId", "", "getContentLayoutId", "()I", "resultKey", "", "getResultKey", "()Ljava/lang/String;", "tabTitles", "", "Lkotlin/jvm/internal/EnhancedNullability;", "getTabTitles", "()[Ljava/lang/String;", "tabTitles$delegate", "Lkotlin/Lazy;", "setupContentView", "view", "Landroid/view/View;", "ColorPickerListener", "Companion", "ColorPickerPagerAdapter", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorPickerTabFragment extends BasePickerFragment {
    public a j;
    public final MutableLiveData<ItemV2> k;
    public final int l;
    public final String m;
    public final Lazy n;

    public interface a {
        void a(String r1);
    }

    public final class b extends FragmentStateAdapter {
        public final /* synthetic */ ColorPickerTabFragment a;

        public final int getItemCount() {
            return 2;
        }

        public final Fragment createFragment(int r3) {
            if (r3 != 0) goto L5;
            Map<String, Integer> r4 = ColorPickerFragment.l;
            ColorPickerStyle r5 = ColorPickerStyle.FONT_COLOR;
            Intrinsics.checkNotNullParameter(r5, "style");
            ColorPickerFragment r0 = new ColorPickerFragment();
            r0.e = r5;
        L9:
            ColorPickerTabFragment r6 = this.a;
            r0.g = r6.j;
            r0.h = r6.k;
            return r0;
        L5:
            if (r3 == 1) goto L7;
            Map<String, Integer> r7 = ColorPickerFragment.l;
            ColorPickerStyle r8 = ColorPickerStyle.FONT_COLOR;
            Intrinsics.checkNotNullParameter(r8, "style");
            r0 = new ColorPickerFragment();
            r0.e = r8;
            goto L9
        L7:
            Map<String, Integer> r9 = ColorPickerFragment.l;
            ColorPickerStyle r10 = ColorPickerStyle.HIGHLIGHT;
            Intrinsics.checkNotNullParameter(r10, "style");
            r0 = new ColorPickerFragment();
            r0.e = r10;
            goto L9
        }

        public b(ColorPickerTabFragment r2, Fragment r3) {
            Intrinsics.checkNotNullParameter(r3, "fragment");
            this.a = r2;
            super(r3);
        }
    }

    public static final class c {
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ColorPickerTabFragment a;

        public d(ColorPickerTabFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.ba0();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ColorPickerTabFragment b;

        public e(TextView r1, ColorPickerTabFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            TextView r6 = this.a;
            Intrinsics.checkNotNull(r6);
            if (r6.getVisibility() != 0) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L22;
            ColorPickerTabFragment r8 = this.b;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
            JSONObject r1 = new JSONObject().put(ResourceData.KEY_TYPE, "transparent");     // Catch: Throwable -> L14
            JSONObject r2 = new JSONObject().put("key", "textBackground").put("value", r1);     // Catch: Throwable -> L14
            a r9 = r8.j;     // Catch: Throwable -> L14
            if (r9 == null) goto L11;
            r9.a(r2.toString());     // Catch: Throwable -> L14
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L14
        L12:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L14
        L16:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L23;
            tt5.a.i("ColorPickerTabFragment", "json error", r12);
            return;
        L23:
            return;
        L11:
            r10 = null;
        L14:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L22:
            return;
        L5:
            r7 = false;
            goto L6
        }
    }

    public static final class f implements UDTabLayoutCoordinator2.a {
        public final /* synthetic */ ColorPickerTabFragment a;

        public f(ColorPickerTabFragment r1) {
            this.a = r1;
        }

        public final void a(int r2, com.larksuite.component.universe_design.tab.b r3) {
            Intrinsics.checkNotNullParameter(r3, "tab");
            r3.b(((String[]) this.a.n.getValue())[r2]);
            ViewGroup.LayoutParams r4 = r3.e.getLayoutParams();
            if (r4 == null) goto L5;
            r4.height = xo5.a.a(60.0f);
        L5:
            r3.e.requestLayout();
        }
    }

    static {
    }

    public ColorPickerTabFragment() {
        this.k = new MutableLiveData();
        this.l = 2131564888;
        this.m = "COLOR_PICKER_EXIT";
        this.n = LazyKt.lazy(new ColorPickerTabFragment$tabTitles$2(this));
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final int ca0() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final String da0() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final void fa0(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ((ImageView) r5.findViewById(2131376031)).setOnClickListener(new d(this));
        ViewPager2 r0 = r5.findViewById(2131392568);
        UDTabLayout r1 = r5.findViewById(2131388030);
        r0.setAdapter(new b(this, this));
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r0);
        new UDTabLayoutCoordinator2(r1, r0, new f(this)).a();
        final TextView r6 = (TextView) r5.findViewById(2131391002);
        r6.setVisibility(8);
        r6.setOnClickListener(new e(r6, this));
        r0.registerOnPageChangeCallback(new ColorPickerTabFragment$setupContentView$3(r6));
    }

    public final void update(ItemV2 r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        this.k.setValue(r2);
    }
}
