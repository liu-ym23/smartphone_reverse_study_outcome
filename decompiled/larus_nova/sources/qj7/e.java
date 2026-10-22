package qj7;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.ug.sdk.luckycat.api.depend.l;
import com.bytedance.ug.sdk.luckycat.impl.manager.b0;
import com.bytedance.ug.sdk.luckycat.impl.manager.c0;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.model.ProfitRemindModel;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f533343a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f533344a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533344a.f533343a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((b0) r100).f271307a.f271311b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(e r100) {
            this.f533344a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f533346b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f533345a.optInt("err_no");     // Catch: Throwable -> L6
            this.f533345a.optString("err_tips");     // Catch: Throwable -> L6
            f r100 = this.f533346b.f533343a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((b0) r100).f271307a.f271311b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(e r100, JSONObject r101) {
            this.f533346b = r100;
            this.f533345a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f533347a;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533347a.f533343a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((b0) r100).f271307a.f271311b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(e r100) {
            this.f533347a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f533348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f533349b;

        public final void a() {
            JSONObject r100 = this.f533348a;
            ProfitRemindModel r101 = null;
            if (r100 != null) goto L37;
        L14:
            f r102 = this.f533349b.f533343a;
            if (r102 == null) goto L38;
            b0 r103 = (b0) r102;
            c0 r104 = r103.f271307a;
            r104.f271310a = r101.f271382b;
            u r105 = u.a();
            long r106 = r103.f271307a.f271310a;
            r105.e("key_next_profit_remind_time");
            SharedPreferences.Editor r107 = r105.f271527a.edit();
            r107.putLong("key_next_profit_remind_time", r106);
            r107.apply();
            r103.f271307a.f271311b = false;
            if (r101.f271381a == false) goto L39;
            r103.f271307a.getClass();
            if (to7.c.b() == null) goto L40;
            l r108 = m.a.f271349a.f271339g;
            if (r108 == null) goto L25;
            r108.e();
        L25:
            l r109 = com.bytedance.ug.sdk.luckycat.impl.manager.c.b();
            if (r109 == null) goto L28;
            r109.e();
        L28:
            JSONObject r110 = new JSONObject();
            r110.put("key", "profit_remind");     // Catch: JSONException -> L31
        L33:
            com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_other_dialog_show", r110, true);
            return;
        L31:
            e = move-exception;
            e.printStackTrace();
            goto L33
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L37:
            ProfitRemindModel r111 = new ProfitRemindModel();     // Catch: Throwable -> L13
            r111.f271381a = r100.optBoolean("should_pop_up", false);     // Catch: Throwable -> L13
            r100.optString("first_line", "");     // Catch: Throwable -> L13
            r100.optString("second_line", "");     // Catch: Throwable -> L13
            r111.f271382b = r100.optLong("next_ts", 0);     // Catch: Throwable -> L13
            r100.optString("friend_url", "");     // Catch: Throwable -> L13
            r100.optDouble("cash", AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L13
            r100.optString("button_text", "");     // Catch: Throwable -> L13
            r100.optString("bg_img_url", "");     // Catch: Throwable -> L13
            String r112 = r100.optString("key", "");     // Catch: Throwable -> L13
            r100.toString();     // Catch: Throwable -> L13
            ProfitRemindModel.ProfitType r113 = ProfitRemindModel.ProfitType.APPRENTICE;     // Catch: Throwable -> L13
            if (ProfitRemindModel.ProfitType.access$000(r113).equals(r112) == false) goto L8;
            r111.f271383c = r113;     // Catch: Throwable -> L13
        L12:
            r101 = r111;
            goto L14
        L8:
            ProfitRemindModel.ProfitType r114 = ProfitRemindModel.ProfitType.INVITE_BONUS;     // Catch: Throwable -> L13
            if (ProfitRemindModel.ProfitType.access$000(r114).equals(r112) == false) goto L11;
            r111.f271383c = r114;     // Catch: Throwable -> L13
            goto L12
        L11:
            r111.f271383c = null;     // Catch: Throwable -> L13
            goto L12
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

        public d(e r100, JSONObject r101) {
            this.f533349b = r100;
            this.f533348a = r101;
        }
    }

    /* JADX INFO: renamed from: qj7.e$e, reason: collision with other inner class name */
    public class RunnableC7340e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f533351b;

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f533351b.f533343a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            this.f533350a.toString();     // Catch: Throwable -> L6
            ((b0) r100).f271307a.f271311b = false;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC7340e(e r100, Throwable r101) {
            this.f533351b = r100;
            this.f533350a = r101;
        }
    }

    public interface f {
    }

    public final void a() {
        Handler r100 = new Handler(Looper.getMainLooper());
        m r101 = m.a.f271349a;     // Catch: Throwable -> L17
        TextUtils.isEmpty("popup/mentor_notify");     // Catch: Throwable -> L17
        String r102 = r101.d(r101.b(r101.j() + "popup/mentor_notify"));     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r102) == false) goto L7;
        r100.post(new a(this));     // Catch: Throwable -> L17
        return;
    L7:
        JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L17
        if (s.a(r103) == true) goto L11;
        r100.post(new b(this, r103));     // Catch: Throwable -> L17
        return;
    L11:
        JSONObject r104 = r103.optJSONObject("data");     // Catch: Throwable -> L17
        if (r104 != null) goto L15;
        r100.post(new c(this));     // Catch: Throwable -> L17
        return;
    L15:
        r100.post(new d(this, r104));     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        r100.post(new RunnableC7340e(this, th));
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

    public e(b0 r100) {
        this.f533343a = r100;
    }
}
