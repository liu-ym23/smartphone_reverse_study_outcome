package com.ss.android.ugc.aweme.framework.services;

import com.ss.android.ugc.aweme.tools.ToolsUrlModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface IStickerService {

    public static class FaceSticker {
        public String extra;
        public ToolsUrlModel fileUrl;
        public String hint;
        public ToolsUrlModel iconUrl;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f450867id;
        public boolean isVideoUsedSticker;
        public String localPath;
        public String name;
        public List<String> requirements;
        public String resourceId;
        public String sdkExtra;
        public long stickerId;
        public List<String> tags;
        public List<String> types;
        private boolean usedFromRecover;

        public FaceSticker() {
            this.requirements = new ArrayList();
        }

        public boolean isUsedFromRecover() {
            return this.usedFromRecover;
        }

        public void setUsedFromRecover(boolean r100) {
            this.usedFromRecover = r100;
        }
    }
}
