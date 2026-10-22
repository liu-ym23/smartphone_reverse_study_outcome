package pd5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<View> f528676a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f528677a = null;

        static {
            f528677a = new c();
        }
    }

    public c() {
        this.f528676a = new CopyOnWriteArrayList();
    }

    public final View a(Context r110) {
        if (this.f528676a.isEmpty() == true) goto L6;
        CopyOnWriteArrayList<View> r100 = this.f528676a;
        return r100.remove(r100.size() - 1);
    L6:
        SwipeMenuLayout r101 = new SwipeMenuLayout(r110);
        r101.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(66)));
        r101.setId(R.id.list_item);
        ConstraintLayout r102 = new ConstraintLayout(r110);
        r102.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(68)));
        r102.setBackgroundResource(R.drawable.list_item_bg_selector);
        r102.setId(R.id.item_content);
        Guideline r103 = new Guideline(r110);
        r103.setId(R.id.list_item_horizontal_guideline);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.orientation = 0;
        r104.guidePercent = 0.5f;
        r102.addView(r103, r104);
        AppCompatImageView r105 = new AppCompatImageView(r110);
        r105.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_doc_colorful));
        r105.setId(R.id.item_icon);
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(zz7.b.g(r110, 40), zz7.b.g(r110, 40));
        r111.bottomToBottom = 0;
        r111.topToTop = 0;
        r111.leftToLeft = 0;
        r111.rightToLeft = R.id.item_name;
        r111.setMarginStart(n.d(16));
        r102.addView(r105, r111);
        AppCompatImageView r106 = new AppCompatImageView(r110);
        r106.setImageResource(R.drawable.ud_icon_wiki_shortcutarrow_colorful);
        r106.setId(R.id.item_shortcut);
        r106.setVisibility(8);
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(zz7.b.g(r110, 40), zz7.b.g(r110, 40));
        r112.bottomToBottom = R.id.item_icon;
        r112.leftToLeft = R.id.item_icon;
        r102.addView(r106, r112);
        SyncStateView r107 = new SyncStateView(r110);
        r107.setVisibility(8);
        r107.setId(R.id.item_sync_state);
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(zz7.b.g(r110, 12), zz7.b.g(r110, 12));
        r113.leftToLeft = R.id.item_name;
        ((ViewGroup.MarginLayoutParams) r113).topMargin = n.d(6);
        r113.topToBottom = R.id.list_item_horizontal_guideline;
        r102.addView(r107, r113);
        View r108 = new View(r110);
        r108.setVisibility(8);
        r108.setId(R.id.padding_view);
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(zz7.b.g(r110, 4), zz7.b.g(r110, 12));
        ((ViewGroup.MarginLayoutParams) r114).topMargin = n.d(6);
        r114.leftToRight = R.id.item_sync_state;
        r114.rightToLeft = R.id.list_item_sync_state_desc;
        r114.topToBottom = R.id.list_item_horizontal_guideline;
        r102.addView(r108, r114);
        SpaceTagTitleView r109 = new SpaceTagTitleView(r110);
        r109.setId(R.id.item_name);
        r109.setTitleSize(16.0f);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(n.d(0), -2);
        r115.horizontalWeight = 1.0f;
        r115.leftToRight = R.id.item_icon;
        r115.rightToLeft = R.id.list_pad_menu_more;
        r115.bottomToTop = R.id.list_item_horizontal_guideline;
        r115.setMarginStart(n.d(12));
        r115.setMarginEnd(n.d(16));
        r102.addView(r109, r115);
        TextView r116 = new TextView(r110);
        r116.setId(R.id.update_time);
        r116.setEllipsize(TextUtils.TruncateAt.END);
        r116.setMaxLines(1);
        r116.setSingleLine();
        r116.setText(R.string.Doc_List_LastUpdateWithSpace);
        r116.setTextColor(n.h(r110, R.color.text_placeholder));
        r116.setTextSize(14.0f);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(n.d(0), -2);
        ((ViewGroup.MarginLayoutParams) r117).topMargin = n.d(2);
        r117.horizontalBias = 0.0f;
        r117.topToBottom = R.id.list_item_horizontal_guideline;
        r117.leftToRight = R.id.list_item_security_desc;
        r117.rightToLeft = R.id.list_pad_menu_more;
        r102.addView(r116, r117);
        TextView r118 = new TextView(r110);
        r118.setId(R.id.list_item_sync_state_desc);
        r118.setEllipsize(TextUtils.TruncateAt.END);
        r118.setMaxLines(1);
        r118.setSingleLine();
        r118.setText(R.string.Doc_List_WaitingForSync);
        r118.setTextColor(n.h(r110, R.color.text_placeholder));
        r118.setTextSize(14.0f);
        r118.setVisibility(8);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) r119).topMargin = n.d(2);
        ((ViewGroup.MarginLayoutParams) r119).rightMargin = n.d(16);
        r119.leftToRight = R.id.padding_view;
        r119.topToBottom = R.id.list_item_horizontal_guideline;
        r102.addView(r118, r119);
        TextView r120 = new TextView(r110);
        r120.setId(R.id.list_item_security_desc);
        r120.setEllipsize(TextUtils.TruncateAt.END);
        r120.setMaxLines(1);
        r120.setTextColor(n.h(r110, R.color.text_placeholder));
        r120.setTextSize(14.0f);
        r120.setVisibility(8);
        r120.setGravity(17);
        r120.setCompoundDrawablePadding(n.d(2));
        ConstraintLayout.LayoutParams r121 = new ConstraintLayout.LayoutParams(-2, -2);
        r121.topToBottom = R.id.item_name;
        r121.bottomToBottom = R.id.update_time;
        r121.leftToRight = R.id.list_item_sync_state_desc;
        r102.addView(r120, r121);
        AppCompatImageView r122 = new AppCompatImageView(r110);
        r122.setId(R.id.item_external_notice);
        r122.setVisibility(8);
        l.c(r122, R.color.icon_n3);
        ConstraintLayout.LayoutParams r123 = new ConstraintLayout.LayoutParams(n.d(20), n.d(20));
        r123.topToTop = 0;
        r123.bottomToBottom = 0;
        r123.rightToLeft = R.id.list_pad_menu_more;
        ((ViewGroup.MarginLayoutParams) r123).rightMargin = n.d(22);
        r102.addView(r122, r123);
        AppCompatImageView r124 = b(r110, R.id.list_pad_menu_more, R.color.bg_body);
        r124.setVisibility(8);
        ConstraintLayout.LayoutParams r125 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r125.topToTop = 0;
        r125.bottomToBottom = 0;
        r125.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r125).rightMargin = n.d(12);
        int r126 = n.d(4);
        r124.setPadding(r126, r126, r126, r126);
        r102.addView(r124, r125);
        r101.addView(r102);
        LinearLayout r127 = new LinearLayout(r110);
        r127.setLayoutParams(new ViewGroup.MarginLayoutParams(n.d(198), -1));
        r127.setId(R.id.item_menu);
        r127.addView(b(r110, R.id.swipe_menu_more, R.color.fill_disable));
        r127.addView(b(r110, R.id.swipe_menu_share, R.color.fill_disable));
        r127.addView(b(r110, R.id.swipe_menu_delete, R.color.function_danger_fill_default));
        r101.addView(r127);
        return r101;
    }

    public static AppCompatImageView b(Context r100, int r101, int r102) {
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        AppCompatImageView r104 = new AppCompatImageView(r100);
        r104.setId(r101);
        r104.setBackgroundColor(n.h(r100, r102));
        r104.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r104.setLayoutParams(r103);
        return r104;
    }
}
