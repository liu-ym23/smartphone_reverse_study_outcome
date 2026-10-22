package com.bytedance.ee.bear.document.frontendlog;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class BatchLoggerMessage implements NonProguard {
    private List<LogItem> logMessages;

    public static class LogItem implements NonProguard {
        private String msg;
        private String timeStamp;

        public LogItem() {
        }

        public String getMsg() {
            return this.msg;
        }

        public String getTimeStamp() {
            return this.timeStamp;
        }

        public void setMsg(String r100) {
            this.msg = r100;
        }

        public void setTimeStamp(String r100) {
            this.timeStamp = r100;
        }
    }

    public BatchLoggerMessage() {
    }

    public List<LogItem> getLogMessages() {
        return this.logMessages;
    }

    public void setLogMessages(List<LogItem> r100) {
        this.logMessages = r100;
    }
}
