package i58;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f488327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f488328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f488329c;

    public /* synthetic */ a(String r100, Integer r101, String r102) {
        this.f488327a = r100;
        this.f488328b = r101;
        this.f488329c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.f488327a;
        Integer r101 = this.f488328b;
        String r102 = this.f488329c;
        FLogger.f375446a.i("AiNoteTracer", "sendAiNoteStartEvent: messageId=" + r100 + ", errorCode=" + r101 + ", errorMsg=" + r102);
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L5;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r100);
    L5:
        if (r101 == null) goto L7;
        r103.put("error_code", r101.intValue());
    L7:
        if (r102 == null) goto L9;
        r103.put("error_msg", r102);
    L9:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("flow_ainote_start");
        r105.f21463a.merge(r104);
        r105.b();
        return Unit.INSTANCE;
    }
}
