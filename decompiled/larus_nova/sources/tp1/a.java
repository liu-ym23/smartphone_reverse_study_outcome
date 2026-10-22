package tp1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSWatermark;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSWatermarkIcon;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.ttvideoengine.model.VideoRef;
import fq1.t;
import java.util.ArrayList;
import java.util.List;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f547000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f547001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f547002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f547003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f547004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f547005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f547006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f547007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<IDefinitionInfo> f547008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VideoRef f547009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f547010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f547011l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f547012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f547013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final VSWatermark f547014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f547015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f547016q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Episode f547017r;

    public static VSWatermarkIcon a() {
        VSWatermarkIcon r100 = new VSWatermarkIcon();
        k r101 = (k) f.c(k.class);
        ArrayList r102 = new ArrayList();
        r102.add("");
        r101.setUrls(r102);
        r100.icon = r101;
        r100.iconWidth = 0L;
        r100.landscapeMargin = 0L;
        r100.portraitMargin = 0L;
        return r100;
    }

    public final VSWatermarkIcon d() {
        VSWatermark r100 = this.f547014o;
        if (r100.vsWatermarkIcon != null) goto L6;
        r100.vsWatermarkIcon = new ArrayList();
        this.f547014o.vsWatermarkIcon.add(a());
        this.f547014o.vsWatermarkIcon.add(a());
    L6:
        return (VSWatermarkIcon) ListProtector.get(this.f547014o.vsWatermarkIcon, 0);
    }

    public final VSWatermarkIcon f() {
        VSWatermark r100 = this.f547014o;
        if (r100.vsWatermarkIcon != null) goto L6;
        r100.vsWatermarkIcon = new ArrayList();
        this.f547014o.vsWatermarkIcon.add(a());
        this.f547014o.vsWatermarkIcon.add(a());
    L6:
        return (VSWatermarkIcon) ListProtector.get(this.f547014o.vsWatermarkIcon, 1);
    }

    public long insert() {
        ContentValues r100 = new ContentValues();
        r100.put("video_id", this.f547000a);
        r100.put("title", this.f547002c);
        r100.put(TTDelegateActivity.DOWNLOAD_SIZE, Long.valueOf(this.f547013n.f547018a));
        r100.put("total_size", Long.valueOf(this.f547013n.f547019b));
        r100.put("time", Long.valueOf(this.f547013n.f547022e));
        r100.put("state", Integer.valueOf(this.f547013n.f547020c));
        r100.put("error_code", Integer.valueOf(this.f547013n.f547021d));
        r100.put("season_name", this.f547003d);
        r100.put("season_id", this.f547004e);
        r100.put("cover_url", this.f547005f);
        r100.put("definition", this.f547007h);
        r100.put("episode_id", Long.valueOf(this.f547011l));
        r100.put("video_key", this.f547013n.f547023f);
        r100.put("video_duration", Long.valueOf(this.f547006g));
        r100.put("current_period", this.f547001b);
        r100.put("item_id", this.f547010k);
        r100.put("style", Integer.valueOf(this.f547012m));
        r100.put("position", this.f547014o.position);
        r100.put("vertical_url", (String) ListProtector.get(e(), 0));
        r100.put("vertical_width", f().iconWidth);
        r100.put("vertical_margin_l", f().landscapeMargin);
        r100.put("vertical_margin_p", f().portraitMargin);
        r100.put("horizontal_url", (String) ListProtector.get(c(), 0));
        r100.put("horizontal_width", d().iconWidth);
        r100.put("horizontal_margin_l", d().landscapeMargin);
        r100.put("horizontal_margin_p", d().portraitMargin);
        r100.put("episode_stage_type", Integer.valueOf(this.f547015p));
        r100.put("download_uid", this.f547016q);
        return c.insert(r100);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("TaskInfo{mVideoId='");     // Catch: Throwable -> L11
        String r101 = this.f547000a;     // Catch: Throwable -> L11
        if (r101 != null) goto L6;
        r101 = "0";
    L6:
        r100.append(r101);     // Catch: Throwable -> L11
        r100.append("', mTitle='");     // Catch: Throwable -> L11
        String r102 = this.f547002c;     // Catch: Throwable -> L11
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r100.append(r102);     // Catch: Throwable -> L11
        r100.append("'}");     // Catch: Throwable -> L11
        return r100.toString();
    L12:
        return super.toString();
    }

    public void update() {
        ContentValues r100 = new ContentValues();
        r100.put("title", this.f547002c);
        r100.put(TTDelegateActivity.DOWNLOAD_SIZE, Long.valueOf(this.f547013n.f547018a));
        r100.put("total_size", Long.valueOf(this.f547013n.f547019b));
        r100.put("time", Long.valueOf(this.f547013n.f547022e));
        r100.put("state", Integer.valueOf(this.f547013n.f547020c));
        r100.put("error_code", Integer.valueOf(this.f547013n.f547021d));
        r100.put("season_name", this.f547003d);
        r100.put("season_id", this.f547004e);
        r100.put("cover_url", this.f547005f);
        r100.put("definition", this.f547007h);
        r100.put("episode_id", Long.valueOf(this.f547011l));
        r100.put("video_key", this.f547013n.f547023f);
        r100.put("video_duration", Long.valueOf(this.f547006g));
        r100.put("current_period", this.f547001b);
        r100.put("item_id", this.f547010k);
        r100.put("style", Integer.valueOf(this.f547012m));
        r100.put("position", this.f547014o.position);
        r100.put("vertical_url", (String) ListProtector.get(e(), 0));
        r100.put("vertical_width", f().iconWidth);
        r100.put("vertical_margin_l", f().landscapeMargin);
        r100.put("vertical_margin_p", f().portraitMargin);
        r100.put("horizontal_url", (String) ListProtector.get(c(), 0));
        r100.put("horizontal_width", d().iconWidth);
        r100.put("horizontal_margin_l", d().landscapeMargin);
        r100.put("horizontal_margin_p", d().portraitMargin);
        r100.put("episode_stage_type", Integer.valueOf(this.f547015p));
        r100.put("download_uid", this.f547016q);
        if (StringUtils.isEmpty(this.f547016q) == false) goto L5;
        c.update(r100, "video_id=? AND download_uid IS NULL", new String[]{this.f547000a});
        return;
    L5:
        c.update(r100, "video_id=? AND download_uid=?", new String[]{this.f547000a, this.f547016q});
    }

    public a() {
        this.f547000a = "0";
        this.f547013n = new b();
        VSWatermark r100 = new VSWatermark();
        r100.position = -1L;
        ArrayList r101 = new ArrayList();
        r101.add(a());
        r101.add(a());
        r100.vsWatermarkIcon = r101;
        this.f547014o = r100;
        this.f547015p = EpisodeMod.EpisodeStageType.UNKNOWN;
        this.f547016q = "";
    }

    public static List<a> b() {
        String r100 = t.a().getCurrentUserId();
        ArrayList r101 = new ArrayList();
        Cursor r102 = c.query(new String[]{"title", TTDelegateActivity.DOWNLOAD_SIZE, "total_size", "time", "state", "error_code", "season_name", "season_id", "cover_url", "definition", "video_id", "episode_id", "video_key", "video_duration", "current_period", "item_id", "style", "position", "vertical_url", "vertical_width", "vertical_margin_l", "vertical_margin_p", "horizontal_url", "horizontal_width", "horizontal_margin_l", "horizontal_margin_p", "episode_stage_type", "download_uid"}, "download_uid=? OR download_uid IS NULL", new String[]{r100}, null, null, String.format("%s DESC", new Object[]{"time"}));
        if (r102 != null) goto L16;
        return null;
    L16:
        if (r102.moveToNext() == false) goto L14;
        a r103 = new a();     // Catch: Throwable -> L12
        r103.f547002c = r102.getString(0);     // Catch: Throwable -> L12
        r103.f547013n.f547018a = r102.getLong(1);     // Catch: Throwable -> L12
        r103.f547013n.f547019b = r102.getLong(2);     // Catch: Throwable -> L12
        r103.f547013n.f547022e = r102.getLong(3);     // Catch: Throwable -> L12
        r103.f547013n.f547020c = r102.getInt(4);     // Catch: Throwable -> L12
        r103.f547013n.f547021d = r102.getInt(5);     // Catch: Throwable -> L12
        r103.f547003d = r102.getString(6);     // Catch: Throwable -> L12
        r103.f547004e = r102.getString(7);     // Catch: Throwable -> L12
        r103.f547005f = r102.getString(8);     // Catch: Throwable -> L12
        r103.f547007h = r102.getString(9);     // Catch: Throwable -> L12
        r103.f547000a = r102.getString(10);     // Catch: Throwable -> L12
        r103.f547011l = r102.getLong(11);     // Catch: Throwable -> L12
        r103.f547013n.f547023f = r102.getString(12);     // Catch: Throwable -> L12
        r103.f547006g = r102.getLong(13);     // Catch: Throwable -> L12
        r103.f547001b = r102.getString(14);     // Catch: Throwable -> L12
        r103.f547010k = r102.getString(15);     // Catch: Throwable -> L12
        r103.f547012m = r102.getInt(16);     // Catch: Throwable -> L12
        r103.f547014o.position = Long.valueOf(r102.getLong(17));     // Catch: Throwable -> L12
        r103.e().set(0, r102.getString(18));     // Catch: Throwable -> L12
        r103.f().iconWidth = Long.valueOf(r102.getLong(19));     // Catch: Throwable -> L12
        r103.f().landscapeMargin = Long.valueOf(r102.getLong(20));     // Catch: Throwable -> L12
        r103.f().portraitMargin = Long.valueOf(r102.getLong(21));     // Catch: Throwable -> L12
        r103.c().set(0, r102.getString(22));     // Catch: Throwable -> L12
        r103.d().iconWidth = Long.valueOf(r102.getLong(23));     // Catch: Throwable -> L12
        r103.d().landscapeMargin = Long.valueOf(r102.getLong(24));     // Catch: Throwable -> L12
        r103.d().portraitMargin = Long.valueOf(r102.getLong(25));     // Catch: Throwable -> L12
        r101.add(r103);     // Catch: Throwable -> L12
        r103.f547015p = r102.getInt(26);     // Catch: Throwable -> L12
        r103.f547016q = r102.getString(27);     // Catch: Throwable -> L12
    L14:
        r102.close();     // Catch: Exception -> L13
    L11:
        return r101;
    }

    public final List<String> c() {
        k r100 = d().icon;
        if (r100 != null) goto L6;
        r100 = (k) f.c(k.class);
        ArrayList r101 = new ArrayList();
        r101.add("");
        r100.setUrls(r101);
        d().icon = r100;
    L6:
        return r100.getUrls();
    }

    public final List<String> e() {
        k r100 = f().icon;
        if (r100 != null) goto L6;
        r100 = (k) f.c(k.class);
        ArrayList r101 = new ArrayList();
        r101.add("");
        r100.setUrls(r101);
        f().icon = r100;
    L6:
        return r100.getUrls();
    }

    public static int delete(String r100, String[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return 0;
    L7:
        return c.delete(r100, r101);
    }
}
