package com.ss.bytertc.engine;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.bytertc.engine.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class PublisherConfiguration {
    private static final String TAG = "PublisherConfiguration";
    private JSONObject mJsonObject;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.PublisherConfiguration$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private PublisherParameters params;

        public PublisherConfiguration build() {
            return new PublisherConfiguration(this, null);
        }

        public Builder() {
            this.params = new PublisherParameters();
        }

        public static /* synthetic */ PublisherParameters access$000(Builder r100) {
            return r100.params;
        }

        public Builder audioChannels(int r100) {
            this.params.audiochannels = r100;
            return this;
        }

        public Builder audioKBitrate(int r100) {
            int r101 = r100 / 1000;
            this.params.audioKBitrate = r101;
            return this;
        }

        public Builder audioSampleRate(int r100) {
            this.params.audiosamplerate = r100;
            return this;
        }

        public Builder defaultLayout(int r100) {
            this.params.defaultLayout = r100;
            return this;
        }

        public Builder extraInfo(String r100) {
            this.params.extraInfo = r100;
            return this;
        }

        public Builder frameRate(int r100) {
            this.params.framerate = r100;
            return this;
        }

        public Builder kBitRate(int r100) {
            this.params.kBitrate = r100;
            return this;
        }

        public Builder liftCycle(int r100) {
            this.params.lifecycle = r100;
            return this;
        }

        public Builder owner(boolean r100) {
            this.params.owner = r100;
            return this;
        }

        public Builder publishUrl(String r100) {
            this.params.mosaicStream = r100;
            return this;
        }

        public Builder size(int r100, int r101) {
            PublisherParameters r102 = this.params;
            r102.width = r100;
            r102.height = r101;
            return this;
        }
    }

    public boolean validate() {
        if (this.mJsonObject == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toJsonString() {
        if (validate() == true) goto L7;
        return null;
    L7:
        return this.mJsonObject.toString();
    }

    public PublisherConfiguration() {
    }

    private PublisherConfiguration(Builder r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
        this.mJsonObject = r101;     // Catch: JSONException -> L5
        r101.put("owner", Builder.access$000(r100).owner);     // Catch: JSONException -> L5
        this.mJsonObject.put(NewBroadcastMonitor.STAGE.LIFECYCLE, Builder.access$000(r100).lifecycle);     // Catch: JSONException -> L5
        this.mJsonObject.put("defaultLayout", Builder.access$000(r100).defaultLayout);     // Catch: JSONException -> L5
        this.mJsonObject.put("width", Builder.access$000(r100).width);     // Catch: JSONException -> L5
        this.mJsonObject.put("height", Builder.access$000(r100).height);     // Catch: JSONException -> L5
        this.mJsonObject.put("framerate", Builder.access$000(r100).framerate);     // Catch: JSONException -> L5
        this.mJsonObject.put("bitrate", Builder.access$000(r100).kBitrate);     // Catch: JSONException -> L5
        this.mJsonObject.put("mosaicStream", Builder.access$000(r100).mosaicStream);     // Catch: JSONException -> L5
        this.mJsonObject.put("extraInfo", Builder.access$000(r100).extraInfo);     // Catch: JSONException -> L5
        this.mJsonObject.put("audiosamplerate", Builder.access$000(r100).audiosamplerate);     // Catch: JSONException -> L5
        this.mJsonObject.put("audiobitrate", Builder.access$000(r100).audioKBitrate * 1000);     // Catch: JSONException -> L5
        this.mJsonObject.put("audiochannels", Builder.access$000(r100).audiochannels);     // Catch: JSONException -> L5
        return;
    L5:
        this.mJsonObject = null;
        LogUtil.w(TAG, "failed to create PublisherConfiguration");
    }

    public /* synthetic */ PublisherConfiguration(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
