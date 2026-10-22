package com.obric.memorydata.sdk.awareness;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u000256B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/EventNames;", "", "<init>", "()V", "EPISODIC_MEMORY_CHANGED", "", "RECEIVE_SMS", "SEND_SMS", "RECEIVE_NOTIFICATION", "CALENDAR_EVENT_CHANGED", "AUTO_MEMORY_CHANGED", "RECORDING_SUMMARY_GENERATED", "ALARM_CHANGED", "CALL_HISTORY_CHANGED", "NOTE_CHANGED", "FILE_CHANGED", "PHOTO_CREATED", "COUNTDOWN_CHANGED", "BLUETOOTH_DEVICE_CONNECTED", "ARRIVE_HOME", "LEAVE_HOME", "ARRIVE_COMPANY", "LEAVE_COMPANY", "ARRIVE_HOME_ENTRANCE", "LEAVE_HOME_ENTRANCE", "ARRIVE_COMPANY_ENTRANCE", "LEAVE_COMPANY_ENTRANCE", "GEOFENCE_ENTERED", "GEOFENCE_EXITED", "ENTER_HOME_GEOFENCE", "EXIT_HOME_GEOFENCE", "ENTER_COMPANY_GEOFENCE", "EXIT_COMPANY_GEOFENCE", "ENTER_AIRPORT", "EXIT_AIRPORT", "ENTER_SUBWAY_STATION", "EXIT_SUBWAY_STATION", "ENTER_RAILWAY_STATION", "EXIT_RAILWAY_STATION", "ENTER_MALL", "EXIT_MALL", "ARRIVE_POI", "LEAVE_POI", "SEDENTARY_STARTED", "SEDENTARY_ENDED", "PROLONGED_HEAD_DOWN_STARTED", "PROLONGED_HEAD_DOWN_ENDED", "FALL_DETECTED", "GLASSES_PUT_ON", "GLASSES_TAKEN_OFF", "isGeoFenceEvent", "", "eventName", "Extras", "ExtraValue", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EventNames {
    public static final String ALARM_CHANGED = "alarm_changed";
    public static final String ARRIVE_COMPANY = "arrive_company";
    public static final String ARRIVE_COMPANY_ENTRANCE = "arrive_company_entrance";
    public static final String ARRIVE_HOME = "arrive_home";
    public static final String ARRIVE_HOME_ENTRANCE = "arrive_home_entrance";
    public static final String ARRIVE_POI = "arrive_poi";
    public static final String AUTO_MEMORY_CHANGED = "auto_memory_changed";
    public static final String BLUETOOTH_DEVICE_CONNECTED = "bluetooth_device_connected";
    public static final String CALENDAR_EVENT_CHANGED = "calendar_event_changed";
    public static final String CALL_HISTORY_CHANGED = "call_history_changed";
    public static final String COUNTDOWN_CHANGED = "countdown_changed";
    public static final String ENTER_AIRPORT = "enter_airport";
    public static final String ENTER_COMPANY_GEOFENCE = "enter_company_geofence";
    public static final String ENTER_HOME_GEOFENCE = "enter_home_geofence";
    public static final String ENTER_MALL = "enter_mall";
    public static final String ENTER_RAILWAY_STATION = "enter_railway_station";
    public static final String ENTER_SUBWAY_STATION = "enter_subway_station";
    public static final String EPISODIC_MEMORY_CHANGED = "episodic_memory_changed";
    public static final String EXIT_AIRPORT = "exit_airport";
    public static final String EXIT_COMPANY_GEOFENCE = "exit_company_geofence";
    public static final String EXIT_HOME_GEOFENCE = "exit_home_geofence";
    public static final String EXIT_MALL = "exit_mall";
    public static final String EXIT_RAILWAY_STATION = "exit_railway_station";
    public static final String EXIT_SUBWAY_STATION = "exit_subway_station";
    public static final String FALL_DETECTED = "fall_detected";
    public static final String FILE_CHANGED = "file_changed";
    public static final String GEOFENCE_ENTERED = "geofence_entered";
    public static final String GEOFENCE_EXITED = "geofence_exited";
    public static final String GLASSES_PUT_ON = "glasses_put_on";
    public static final String GLASSES_TAKEN_OFF = "glasses_taken_off";
    public static final EventNames INSTANCE = null;
    public static final String LEAVE_COMPANY = "leave_company";
    public static final String LEAVE_COMPANY_ENTRANCE = "leave_company_entrance";
    public static final String LEAVE_HOME = "leave_home";
    public static final String LEAVE_HOME_ENTRANCE = "leave_home_entrance";
    public static final String LEAVE_POI = "leave_poi";
    public static final String NOTE_CHANGED = "note_changed";
    public static final String PHOTO_CREATED = "photo_created";
    public static final String PROLONGED_HEAD_DOWN_ENDED = "prolonged_head_down_ended";
    public static final String PROLONGED_HEAD_DOWN_STARTED = "prolonged_head_down_started";
    public static final String RECEIVE_NOTIFICATION = "receive_notification";
    public static final String RECEIVE_SMS = "receive_sms";
    public static final String RECORDING_SUMMARY_GENERATED = "recording_summary_generated";
    public static final String SEDENTARY_ENDED = "sedentary_ended";
    public static final String SEDENTARY_STARTED = "sedentary_started";
    public static final String SEND_SMS = "send_sms";

    static {
        INSTANCE = new EventNames();
    }

    private EventNames() {
    }

    public final boolean isGeoFenceEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (Intrinsics.areEqual(r100, GEOFENCE_ENTERED) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, GEOFENCE_EXITED) == true) goto L8;
        return false;
    }
}
