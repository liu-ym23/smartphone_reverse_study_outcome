package yy7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import wy7.c;

/* JADX INFO: loaded from: classes24.dex */
public interface a {

    /* JADX INFO: renamed from: yy7.a$a, reason: collision with other inner class name */
    public static class C8404a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f569487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f569488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f569489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f569490d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f569491e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f569492f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f569493g;

        public C8404a(String r100, String r101, String r102, boolean r103, boolean r104, String r105, String r106) {
            this.f569487a = r100;
            this.f569488b = r101;
            this.f569489c = r102;
            this.f569490d = r103;
            this.f569491e = r104;
            this.f569492f = r105;
            this.f569493g = r106;
        }
    }

    C8404a getAccountInfo();

    Map<String, c> getChatterByIds(List<String> r100);

    Context getContext();

    String getDebugUrl();

    String getDynamicDomain(String r100);

    Locale getLanguageSetting();

    String getLoginUserId();

    Long getNtpTime();

    boolean is12HourClock();

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void openUrl(Context r100, String r101, boolean r102, boolean r103, Boolean r104, String r105, Bundle r106);

    void pickGroupMember(Activity r100, String r101, List<String> r102, boolean r103, String r104, IGetDataCallback<List<ChatChatter>> r105);

    void pickTargetMember(Activity r100, List<String> r101, List<String> r102, boolean r103, String r104, IGetDataCallback<List<ChatChatter>> r105);

    void showProfile(Context r100, String r101);

    void startContactsProfileActivityByChatterId(Context r100, String r101, String r102);
}
