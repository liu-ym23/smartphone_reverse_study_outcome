package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR6\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lls1/r;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "harReportEnable", "getHarReportEnable", "setHarReportEnable", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "eventTriggerList", "Ljava/util/ArrayList;", "getEventTriggerList", "()Ljava/util/ArrayList;", "setEventTriggerList", "(Ljava/util/ArrayList;)V", "timerTriggerEnable", "getTimerTriggerEnable", "setTimerTriggerEnable", "", "timerTriggerInterval", "J", "getTimerTriggerInterval", "()J", "setTimerTriggerInterval", "(J)V", "eventTriggerInterval", "getEventTriggerInterval", "setEventTriggerInterval", "addPredictListenerEnable", "getAddPredictListenerEnable", "setAddPredictListenerEnable", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("add_predict_listener_enable")
    private boolean addPredictListenerEnable;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("event_trigger_interval")
    private long eventTriggerInterval;

    @SerializedName("event_trigger_list")
    private ArrayList<String> eventTriggerList;

    @SerializedName("har_report_enable")
    private boolean harReportEnable;

    @SerializedName("timer_trigger_enable")
    private boolean timerTriggerEnable;

    @SerializedName("timer_trigger_interval")
    private long timerTriggerInterval;

    public r() {
        this.enable = true;
        ArrayList<String> r100 = new ArrayList();
        this.eventTriggerList = r100;
        this.timerTriggerInterval = 15000;
        this.eventTriggerInterval = 15000;
        this.addPredictListenerEnable = true;
        r100.isEmpty();
    }
}
