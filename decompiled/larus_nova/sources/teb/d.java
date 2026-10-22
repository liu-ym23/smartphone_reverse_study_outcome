package teb;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f545645g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FeedListAdapter f545646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile RecyclerView f545647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.Recycler f545648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<RecyclerView.ViewHolder> f545649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, Pair<Long, RecyclerView.ViewHolder>> f545650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f545651f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f545652a;

        public final void a() {
            if (this.f545652a.f545647b.getScrollState() == 0) goto L5;
            return;
        L5:
            d r100 = this.f545652a;
            if (r100.f545648c == null) goto L8;
            int r101 = r100.f545647b.getChildCount();
            View r102 = this.f545652a.f545647b.getChildAt(0);
            View r103 = this.f545652a.f545647b.getChildAt(r101 - 1);
            HashSet r104 = new HashSet();
            int r105 = this.f545652a.f545647b.getChildAdapterPosition(r102);
            int r106 = this.f545652a.f545647b.getChildAdapterPosition(r103);
            int r107 = 1;
        L13:
            if (r107 > 8) goto L22;
            int r108 = r105 - r107;
            if (r108 < 0) goto L17;
            r104.add(Integer.valueOf(r108));
        L17:
            int r109 = r106 + r107;
            if (r109 > (this.f545652a.f545646a.getItemCount() - 1)) goto L20;
            r104.add(Integer.valueOf(r109));
        L20:
            r107 = r107 + 1;
            goto L13
        L22:
            if (d.f545645g == false) goto L25;
            Log.d("FeedPreBinder", "================================");
            Log.d("FeedPreBinder", "firstChildAdapterPosition=" + r105);
            Log.d("FeedPreBinder", "lastChildAdapterPosition=" + r106);
            Log.d("FeedPreBinder", "tempSet=" + r104);
        L25:
            if (this.f545652a.f545649d == null) goto L34;
            int r110 = 0;
        L28:
            if (r110 >= this.f545652a.f545649d.size()) goto L34;
            RecyclerView.ViewHolder r111 = (RecyclerView.ViewHolder) ListProtector.get(this.f545652a.f545649d, r110);
            int r112 = r111.getAdapterPosition();
            r104.remove(Integer.valueOf(r112));
            if (d.f545645g == false) goto L32;
            Log.e("FeedPreBinder", "cachedView index=" + r110 + " adapterPosition= " + r112 + " holder=" + r111);
        L32:
            r110 = r110 + 1;
        L34:
            if (d.f545645g == false) goto L36;
            Log.d("FeedPreBinder", "tempSet without cachedView=" + r104);
            Log.d("FeedPreBinder", "================================");
        L36:
            HashMap<String, Pair<Long, RecyclerView.ViewHolder>> r113 = new HashMap();
            Iterator r114 = r104.iterator();
        L38:
            if (r114.hasNext() == false) goto L47;
            Integer r115 = (Integer) r114.next();
            UIFeedCard r116 = this.f545652a.f545646a.getItem(r115.intValue());
            String r117 = r116.getId();
            long r118 = r116.getUpdateTime();
            Pair<Long, RecyclerView.ViewHolder> r119 = this.f545652a.f545650e.remove(r117);
            if (r119 == null) goto L38;
            if (((Long) r119.first).longValue() != r118) goto L38;
            r113.put(r117, r119);
            if (d.f545645g == false) goto L38;
            Log.d("FeedPreBinder", "put into newExtentCachedView: use already prebinded position=" + r115 + " id=" + r117 + " updateTime=" + r118 + " holder=" + r119.second);
            goto L38
        L47:
            Iterator<Pair<Long, RecyclerView.ViewHolder>> r120 = this.f545652a.f545650e.values().iterator();
        L49:
            if (r120.hasNext() == false) goto L51;
            this.f545652a.f545647b.getRecycledViewPool().putRecycledView((RecyclerView.ViewHolder) r120.next().second);
            goto L49
        L51:
            this.f545652a.f545650e.clear();
            Iterator r121 = r104.iterator();
        L53:
            if (r121.hasNext() == false) goto L80;
            Integer r122 = (Integer) r121.next();
            UIFeedCard r123 = this.f545652a.f545646a.getItem(r122.intValue());
            String r124 = r123.getId();
            long r125 = r123.getUpdateTime();
            if (r113.containsKey(r124) == true) goto L53;
            int r126 = this.f545652a.f545646a.getItemViewType(r122.intValue());
            RecyclerView.ViewHolder r127 = this.f545652a.f545647b.getRecycledViewPool().getRecycledView(r126);
            if (r127 != null) goto L60;
            d r128 = this.f545652a;
            r127 = r128.f545646a.createViewHolder(r128.f545647b, r126);
        L60:
            d r129 = this.f545652a;
            r129.getClass();
            ViewGroup.LayoutParams r130 = r127.itemView.getLayoutParams();
            if (r130 != null) goto L64;
            RecyclerView.LayoutParams r131 = r129.f545647b.getLayoutManager().generateDefaultLayoutParams();
            r127.itemView.setLayoutParams(r131);
        L82:
            d27.b.c(r131, "mViewHolder", r127);     // Catch: IllegalAccessException -> L74
        L76:
            this.f545652a.f545648c.bindViewToPosition(r127.itemView, r122.intValue());
            r113.put(r124, new Pair(Long.valueOf(r125), r127));
            if (d.f545645g == false) goto L53;
            Log.d("FeedPreBinder", "put into newExtentCachedView: prebinded  position=" + r122 + " id=" + r124 + " updateTime=" + r125 + " holder=" + r127);
        L74:
            e = move-exception;
            Log.e("FeedPreBinder", "fixLayoutParams: set rvLayoutParams.mViewHolder error", e);
            goto L76
        L64:
            if ((r130 instanceof RecyclerView.LayoutParams) == true) goto L66;
        L68:
            boolean r132 = false;
        L69:
            if (r132 == true) goto L71;
            r131 = r129.f545647b.getLayoutManager().generateLayoutParams(r130);
            r127.itemView.setLayoutParams(r131);
            goto L82
        L71:
            r131 = (RecyclerView.LayoutParams) r130;
            goto L82
        L66:
            if (r129.f545647b.getLayoutManager().checkLayoutParams((RecyclerView.LayoutParams) r130) == false) goto L68;
            r132 = true;
            goto L69
        L80:
            this.f545652a.f545650e = r113;
            return;
        L8:
            if (d.f545645g == false) goto L101;
            Log.e("FeedPreBinder", "recycler is null.");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100) {
            this.f545652a = r100;
        }
    }

    static {
        f545645g = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
    }

    public d() {
        this.f545648c = null;
        this.f545649d = null;
        this.f545650e = new HashMap();
        this.f545651f = new a(this);
    }
}
