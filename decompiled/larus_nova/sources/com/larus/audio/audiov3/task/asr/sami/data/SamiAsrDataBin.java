package com.larus.audio.audiov3.task.asr.sami.data;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class SamiAsrDataBin {

    @SerializedName("extra")
    public SamiAsrDataExtra extra;

    @SerializedName("results")
    public List<a> results;

    public static class a {

        @SerializedName("index")
        public int Index;

        @SerializedName("confidence")
        public float confidence;

        @SerializedName("definite")
        public boolean definite;

        @SerializedName("end_time")
        public float endTime;

        @SerializedName("is_interim")
        public boolean isInterim;

        @SerializedName("is_vad_finished")
        public boolean isVadFinished;

        @SerializedName(ILoadStallMonitor.START_TIME)
        public float startTime;

        @SerializedName("stream_asr_finish")
        public boolean streamAsrFinish;

        @SerializedName("text")
        public String text;

        /* JADX INFO: renamed from: com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin$a$a, reason: collision with other inner class name */
        public class C3956a {

            @SerializedName("confidence")
            public float confidence;

            @SerializedName("end_time")
            public float enTime;

            @SerializedName("oi_decoding_info")
            public Object oiDecodingInfo;

            @SerializedName("semantic_related_to_prev")
            public Object semanticRelatedToPrev;

            @SerializedName(ILoadStallMonitor.START_TIME)
            public float starTime;

            @SerializedName("text")
            public String text;

            /* JADX INFO: renamed from: com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin$a$a$a, reason: collision with other inner class name */
            public class C3957a {

                @SerializedName("end_time")
                public float endTime;

                @SerializedName(ILoadStallMonitor.START_TIME)
                public float starTime;

                @SerializedName("tag")
                public String tag;

                @SerializedName(EffectConfiguration.KEY_SEARCH_WORD)
                public String word;
            }
        }

        public a() {
        }
    }

    public SamiAsrDataBin() {
    }
}
