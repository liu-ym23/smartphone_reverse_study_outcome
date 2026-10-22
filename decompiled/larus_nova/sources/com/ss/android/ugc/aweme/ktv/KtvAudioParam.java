package com.ss.android.ugc.aweme.ktv;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R0\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160;0.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00101\"\u0004\b=\u00103R0\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160;0.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00101\"\u0004\b@\u00103¨\u0006A"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;", "Ljava/io/Serializable;", "()V", "audioTrackIndex", "", "getAudioTrackIndex", "()I", "setAudioTrackIndex", "(I)V", "audioTrackUuid", "", "getAudioTrackUuid", "()Ljava/lang/String;", "setAudioTrackUuid", "(Ljava/lang/String;)V", "balanceFilter", "getBalanceFilter", "setBalanceFilter", "duration", "getDuration", "setDuration", "enableAudioTrack", "", "getEnableAudioTrack", "()Z", "setEnableAudioTrack", "(Z)V", "loudness", "", "getLoudness", "()D", "setLoudness", "(D)V", "peak", "getPeak", "setPeak", "playStart", "getPlayStart", "setPlayStart", "playUrl", "Lcom/ss/android/ugc/aweme/base/model/UrlModel;", "getPlayUrl", "()Lcom/ss/android/ugc/aweme/base/model/UrlModel;", "setPlayUrl", "(Lcom/ss/android/ugc/aweme/base/model/UrlModel;)V", "timeList", "", "Lcom/ss/android/ugc/aweme/ktv/AudioInterval;", "getTimeList", "()Ljava/util/List;", "setTimeList", "(Ljava/util/List;)V", ITTVideoEngineEventSource.KEY_VOLUME, "", "getVolume", "()F", "setVolume", "(F)V", "volumeFilters", "Lkotlin/Pair;", "getVolumeFilters", "setVolumeFilters", "volumeFiltersNLE", "getVolumeFiltersNLE", "setVolumeFiltersNLE", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class KtvAudioParam implements Serializable {

    @SerializedName("audio_track_index")
    private int audioTrackIndex;

    @SerializedName("audio_uuid")
    private String audioTrackUuid;

    @SerializedName("balance_filter_index")
    private int balanceFilter;

    @SerializedName("play_url_duration")
    private int duration;

    @SerializedName("enable_audio_track")
    private boolean enableAudioTrack;

    @SerializedName(TTVideoEngineInterface.DASP_SIGNAL_VOLUME_LOUDNESS)
    private double loudness;

    @SerializedName("volume_peak")
    private double peak;

    @SerializedName("play_url_start")
    private int playStart;

    @SerializedName("play_url")
    private UrlModel playUrl;

    @SerializedName("play_time_list")
    private List<AudioInterval> timeList;

    @SerializedName(ITTVideoEngineEventSource.KEY_VOLUME)
    private float volume;

    @SerializedName("volume_filter_index_list")
    private List<Pair<Integer, Boolean>> volumeFilters;

    @SerializedName("volume_filter_uuid_list")
    private List<Pair<String, Boolean>> volumeFiltersNLE;

    public KtvAudioParam() {
        this.timeList = new ArrayList();
        this.audioTrackIndex = -1;
        this.audioTrackUuid = "";
        this.volumeFilters = new ArrayList();
        this.volumeFiltersNLE = new ArrayList();
        this.balanceFilter = -1;
        this.enableAudioTrack = true;
        this.volume = 0.5f;
    }

    public final int getAudioTrackIndex() {
        return this.audioTrackIndex;
    }

    public final String getAudioTrackUuid() {
        return this.audioTrackUuid;
    }

    public final int getBalanceFilter() {
        return this.balanceFilter;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getEnableAudioTrack() {
        return this.enableAudioTrack;
    }

    public final double getLoudness() {
        return this.loudness;
    }

    public final double getPeak() {
        return this.peak;
    }

    public final int getPlayStart() {
        return this.playStart;
    }

    public final UrlModel getPlayUrl() {
        return this.playUrl;
    }

    public final List<AudioInterval> getTimeList() {
        return this.timeList;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final List<Pair<Integer, Boolean>> getVolumeFilters() {
        return this.volumeFilters;
    }

    public final List<Pair<String, Boolean>> getVolumeFiltersNLE() {
        return this.volumeFiltersNLE;
    }

    public final void setAudioTrackIndex(int r100) {
        this.audioTrackIndex = r100;
    }

    public final void setAudioTrackUuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioTrackUuid = r100;
    }

    public final void setBalanceFilter(int r100) {
        this.balanceFilter = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setEnableAudioTrack(boolean r100) {
        this.enableAudioTrack = r100;
    }

    public final void setLoudness(double r100) {
        this.loudness = r100;
    }

    public final void setPeak(double r100) {
        this.peak = r100;
    }

    public final void setPlayStart(int r100) {
        this.playStart = r100;
    }

    public final void setPlayUrl(UrlModel r100) {
        this.playUrl = r100;
    }

    public final void setTimeList(List<AudioInterval> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timeList = r100;
    }

    public final void setVolume(float r100) {
        this.volume = r100;
    }

    public final void setVolumeFilters(List<Pair<Integer, Boolean>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.volumeFilters = r100;
    }

    public final void setVolumeFiltersNLE(List<Pair<String, Boolean>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.volumeFiltersNLE = r100;
    }
}
