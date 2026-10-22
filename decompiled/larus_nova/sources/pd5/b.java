package pd5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<View> f528674a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f528675a = null;

        static {
            f528675a = new b();
        }
    }

    public b() {
        this.f528674a = new CopyOnWriteArrayList();
    }

    public final View a(Context r110) {
        if (this.f528674a.isEmpty() == true) goto L6;
        CopyOnWriteArrayList<View> r111 = this.f528674a;
        return r111.remove(r111.size() - 1);
    L6:
        ConstraintLayout r100 = new ConstraintLayout(r110);
        r100.setId(R.id.grid_item);
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-1, n.l(r110, R.dimen.list_grid_item_height));
        r100.setBackgroundResource(R.drawable.list_grid_item_bg);
        r100.setLayoutParams(r101);
        View r102 = new View(r110);
        r102.setBackgroundResource(R.drawable.list_grid_item_shadow);
        l.b(r102, R.color.bg_body);
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-1, -1);
        int r104 = n.d(4);
        r103.setMargins(r104, r104, r104, r104);
        r100.addView(r102, r103);
        AppCompatImageView r105 = new AppCompatImageView(r110);
        r105.setId(R.id.list_grid_thumbnail);
        r105.setBackgroundResource(R.drawable.list_grid_item_shadow);
        l.b(r105, R.color.bg_body);
        r105.setImageResource(R.drawable.list_grid_placeholder);
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(-1, -1);
        int r107 = n.d(4);
        r106.setMargins(r107, r107, r107, r107);
        r100.addView(r105, r106);
        View r108 = new View(r110);
        r108.setBackgroundColor(r110.getResources().getColor(R.color.list_grid_item_mask));
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(-1, -1);
        int r112 = n.d(4);
        r109.setMargins(r112, r112, r112, r112);
        r100.addView(r108, r109);
        AppCompatImageView r113 = new AppCompatImageView(r110);
        r113.setId(R.id.list_grid_folder_thumbnail);
        r113.setImageResource(kac.a.b(R.drawable.ud_icon_file_sharefolder_colorful));
        r113.setVisibility(8);
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(n.d(48), n.d(48));
        ((ViewGroup.MarginLayoutParams) r114).topMargin = n.d(22);
        r114.leftToLeft = 0;
        r114.rightToRight = 0;
        r114.topToTop = 0;
        r100.addView(r113, r114);
        AppCompatImageView r115 = new AppCompatImageView(r110);
        r115.setId(R.id.list_grid_pin);
        r115.setBackgroundResource(R.drawable.ic_icon_notification_shape);
        r115.setImageResource(R.drawable.ud_icon_collect_filled);
        l.c(r115, R.color.colorful_yellow);
        int r116 = n.d(3);
        r115.setPadding(r116, r116, r116, r116);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(n.d(20), n.d(20));
        ((ViewGroup.MarginLayoutParams) r117).topMargin = n.d(9);
        r117.setMarginEnd(n.d(9));
        r117.topToTop = 0;
        r117.rightToLeft = R.id.list_external_notice;
        r100.addView(r115, r117);
        AppCompatImageView r118 = new AppCompatImageView(r110);
        r118.setId(R.id.list_external_notice);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(n.d(20), n.d(20));
        r119.rightToRight = 0;
        r119.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r119).topMargin = n.d(9);
        r119.setMarginEnd(n.d(9));
        int r120 = n.d(2);
        r115.setPadding(r120, r120, r120, r120);
        r118.setVisibility(8);
        r118.setBackgroundResource(R.drawable.ic_icon_notification_shape);
        r118.setImageResource(R.drawable.ud_icon_warning_outlined);
        l.c(r118, R.color.icon_disable);
        r100.addView(r118, r119);
        View r121 = new View(r110);
        r121.setBackgroundResource(R.color.line_border_card);
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(-1, n.c(0.5f));
        r122.bottomToTop = R.id.list_grid_item_container;
        r100.addView(r121, r122);
        ConstraintLayout r123 = new ConstraintLayout(r110);
        r123.setId(R.id.list_grid_item_container);
        ConstraintLayout.LayoutParams r124 = new ConstraintLayout.LayoutParams(-1, n.d(60));
        int r125 = n.d(1);
        r124.setMargins(r125, r125, r125, r125);
        r124.bottomToBottom = 0;
        r123.setPadding(0, n.d(6), 0, n.d(6));
        r123.setBackgroundResource(R.drawable.list_pin_item_container_bg);
        r100.addView(r123, r124);
        AppCompatImageView r126 = new AppCompatImageView(r110);
        r126.setId(R.id.list_grid_item_type);
        ConstraintLayout.LayoutParams r127 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r127.setMarginStart(n.d(8));
        r127.topToTop = 0;
        r127.bottomToBottom = 0;
        r127.leftToLeft = 0;
        r126.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_doc_colorful));
        r123.addView(r126, r127);
        AppCompatImageView r128 = new AppCompatImageView(r110);
        r128.setId(R.id.list_grid_item_shortcut);
        r128.setVisibility(8);
        ConstraintLayout.LayoutParams r129 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r129.bottomToBottom = R.id.list_grid_item_type;
        r129.leftToLeft = R.id.list_grid_item_type;
        r128.setImageResource(R.drawable.ud_icon_wiki_shortcutarrow_colorful);
        r123.addView(r128, r129);
        SyncStateView r130 = new SyncStateView(r110);
        r130.setId(R.id.list_grid_item_sync_state);
        r130.setVisibility(8);
        ConstraintLayout.LayoutParams r131 = new ConstraintLayout.LayoutParams(n.d(14), n.d(14));
        ((ViewGroup.MarginLayoutParams) r131).bottomMargin = n.d(3);
        r131.bottomToBottom = 0;
        r131.rightToLeft = R.id.list_grid_item_title;
        r123.addView(r130, r131);
        TextView r132 = new TextView(r110);
        r132.setId(R.id.list_grid_item_title);
        ConstraintLayout.LayoutParams r133 = new ConstraintLayout.LayoutParams(0, -2);
        r133.setMarginStart(n.d(8));
        r133.setMarginEnd(n.d(4));
        r132.setTextSize(14.0f);
        r132.setTextColor(n.h(r110, R.color.text_title));
        r132.setMaxLines(2);
        r132.setEllipsize(TextUtils.TruncateAt.END);
        r133.leftToRight = R.id.list_grid_item_type;
        r133.rightToLeft = R.id.list_grid_more;
        r133.topToTop = 0;
        r133.bottomToTop = R.id.list_grid_item_tag;
        r123.addView(r132, r133);
        SpaceTagTitleView r134 = new SpaceTagTitleView(r110);
        r134.setId(R.id.list_grid_item_tag);
        r134.setLabelsMargin(0);
        ConstraintLayout.LayoutParams r135 = new ConstraintLayout.LayoutParams(0, -2);
        r135.setMarginStart(n.d(8));
        r135.setMarginEnd(n.d(4));
        r135.leftToRight = R.id.list_grid_item_type;
        r135.rightToLeft = R.id.list_grid_more;
        r135.topToBottom = R.id.list_grid_item_title;
        r135.bottomToBottom = 0;
        r123.addView(r134, r135);
        AppCompatImageView r136 = new AppCompatImageView(r110);
        r136.setId(R.id.list_grid_more);
        ConstraintLayout.LayoutParams r137 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r137.setMarginEnd(n.d(4));
        r137.rightToRight = 0;
        r137.topToTop = 0;
        r137.bottomToBottom = 0;
        r136.setImageResource(R.drawable.list_grid_more_dot);
        l.c(r136, R.color.icon_n3);
        r123.addView(r136, r137);
        return r100;
    }
}
