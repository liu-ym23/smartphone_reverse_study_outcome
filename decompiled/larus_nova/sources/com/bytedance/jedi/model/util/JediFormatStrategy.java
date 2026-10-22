package com.bytedance.jedi.model.util;

import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogcatLogStrategy;

/* JADX INFO: loaded from: classes19.dex */
public class JediFormatStrategy implements FormatStrategy {

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LogcatLogStrategy f251196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f251197b;

        private Builder() {
            this.f251197b = "PRETTY_LOGGER";
        }

        public /* synthetic */ Builder(int r100) {
            this();
        }
    }

    public JediFormatStrategy(Builder r100) {
        LogcatLogStrategy r101 = r100.f251196a;
        String r102 = r100.f251197b;
    }
}
